package noahp78.survive.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import noahp78.survive.networking.NetworkingUtil;
import noahp78.survive.networking.requests.authRequest;
import noahp78.survive.networking.requests.gamedataRequest;
import noahp78.survive.networking.requests.initRequest;
import noahp78.survive.networking.requests.moveRequest;
import noahp78.survive.networking.responses.authResponse;
import noahp78.survive.networking.responses.gamedataResponse;
import noahp78.survive.networking.responses.initResponse;
import noahp78.survive.networking.responses.moveResponse;
import noahp78.survive.networking.responses.playerJoinEvent;
import noahp78.survive.networking.responses.timeResponse;
import noahp78.survive.server.generators.WorldGenV1;
import noahp78.survive.server.managers.ServerSidePlayer;
import noahp78.survive.server.tick.TickHandler;
import noahp78.survive.util.authUtils;
import noahp78.survive.util.logManager;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class serverStart {
	private static int PlayerCount = 0;
	private static int TickCount = 0;
	private static String serverVersion = "Dev1";
	public static HashMap worldMap = new HashMap();
	private static HashMap worldGenMap = new HashMap();
	private static Server server;
	private static HashMap<Integer, ServerSidePlayer> playerMap = new HashMap<Integer, ServerSidePlayer>();
	
	
	public static void StartServer(int Port){
		logManager.LogInfo("Server starting on port: " + Port + "And UDP port " + (Port+1));
		logManager.LogInfo("Generating World");
		logManager.LogInfo("This server is running the OLD generation method. Mods FILES don't work here yet!");
		Random randomGenerator = new Random();
	
		Port=51213;
		WorldGenV1.GenerateWorld();
			
		logManager.LogInfo("World Generation Complete...");
		logManager.LogInfo("Starting ServerSide Tick Handler");
		Timer timer = new Timer();
		timer.schedule( new TimerTask() {
		    public void run() {
		    	TickCount++;
		    	TickHandler.Tick();
		    }
		 }, 0, 1*1000);
		
		server = new Server(65536,65536);
		   server.start();
		   Kryo kryo = server.getKryo();
		   NetworkingUtil.register(server);
		   
		   try {
			server.bind(Port, (Port+1));
		} catch (IOException e) {
			System.out.println("Server can't bind to port");
			System.out.println(e.getCause());
		}
		    server.addListener(new Listener() {
		        public void received (Connection connection, Object object) {
		        	if (object instanceof initRequest) {
		        		//Basic initial connection stuff... 
		        		logManager.LogInfo("[ServerConnection]" + connection.getRemoteAddressTCP() + " Connected to the server");
		        		 initResponse response = new initResponse();
		        		 PlayerCount = server.getConnections().length;
		        		 response.mayConnect = true;
		        		 response.playercount = PlayerCount;
		        		 response.ServerVersion = serverVersion;
		        		 connection.sendTCP(response);
		        		 playerJoinEvent response2 = new playerJoinEvent();
		        		 response2.charID = PlayerCount;
		        		 logManager.LogDebug("[server] Sending LoginEvent to all players");
		        		 server.sendToAllTCP(response2); 
		        	}
		        	if (object instanceof authRequest) {
		        		logManager.LogDebug("Got AUTH Request");
		        		String username = ((authRequest) object).username;
		        		String token = ((authRequest) object).token;
		        		String IP = ((authRequest) object).ip;
		        		
		        		try {
							if (authUtils.CheckAuth(username, token, IP)==true){
								authResponse response = new authResponse();
								response.GoOn = true;
								response.error = "n.i.p";
								connection.sendTCP(response);
								PlayerCount = server.getConnections().length;
								ServerSidePlayer P = new ServerSidePlayer();
								P.tileX=0;
								P.tileZ=0;
								P.username=username;
								playerMap.put(PlayerCount, P);
								//And now, Notify ALL the players ingame
								
							}
						} catch (Exception e) {
							logManager.LogWarning("Auth servers might be down... Or you aren't connected to the internet");
							e.printStackTrace();
						}
		        	}
		        	if (object instanceof gamedataRequest){
		        		gamedataResponse response = new gamedataResponse();
		        		response.WorldMap = getWorldGenMap();
		        		//response.Players = null;
		        		PlayerCount = server.getConnections().length;
		        		connection.sendTCP(response);
		        	}
		        	if (object instanceof moveRequest){
		        		moveResponse response = new moveResponse();
		        		int CharID = ((moveRequest) object).CharID;
		        		int x = ((moveRequest) object).tileX;
		        		int z = ((moveRequest) object).tileZ;
		        		//logManager.LogDebug("[Server]Sending Movement Packet to all");
		        		response.CharID = CharID;
		        		response.x = x;
		        		response.y = z;
		        		server.sendToAllTCP(response);
		        	}
		        	
		        	
		        }
		        
		     });
		    EnterCommand();
	}
	public static HashMap getWorldGenMap() {
		return worldGenMap;
	}
	private static void EnterCommand(){
		System.out.print("> ");
	}
	public static void SendnewTime(int time){
		timeResponse response = new timeResponse();
		response.newTime = time;
		
		if (PlayerCount < 1){
			//System.out.println("Nobody notified about new time, Nobody is connected!");
		}else{
		server.sendToAllTCP(response);
		}
	}
}
