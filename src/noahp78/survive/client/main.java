package noahp78.survive.client;
/* this is our client side. Server side will be implented when we get MP support
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import noahp78.survive.client.networking.mainClient;
import noahp78.survive.client.render.Camera;
import noahp78.survive.client.render.ConnectionScreen;
import noahp78.survive.client.render.MainMenu;
import noahp78.survive.client.render.MultiplayerRender;
import noahp78.survive.client.render.WorldRender;
import noahp78.survive.client.render.chatRender;
import noahp78.survive.client.render.loginMenu;
import noahp78.survive.client.render.timeRender;
import noahp78.survive.plugin.EventPublisher;
import noahp78.survive.plugin.events.ClientInitEvent;
import noahp78.survive.plugin.loader.pluginLoader;
import noahp78.survive.server.serverStart;
import noahp78.survive.util.logManager;
import noahp78.survive.util.map.DefaultTileSet;
import noahp78.survive.util.map.TileRegistry;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;


public class main extends BasicGame {
	//private static TiledMap grassMap;
	
	// 1 is main menu, 2 is connectionscreen, 3 = game, 4 = paused
	// 5 = login screen, 6= connect to server screen 7 = ChatOverlay
	
	public static int Menu = 5;
	
	public static int CharX = 0;
	public static int CharY = 0;
	//image Init
	public Image img;
	public Image woodIcon;
	
	public static HashMap m = new HashMap();
	
	/** True if space is down */
	private boolean left;
	/** True if left shift is down */
	private boolean right;
	/** True if right shift is down */
	private boolean up;
	private boolean down;
	private boolean use;
	private boolean enter;
	private Font font;
	private TrueTypeFont ttf;
	private Font font2;
	private TrueTypeFont ttf2;
	private Font font3;
	private TrueTypeFont ttf3;
	
	
	private boolean enterswitch = false;
	private boolean Upswitch = false;
	public static int FrameCount = 1600;
	
	private boolean Downswitch = false;
	private boolean Useswitch = false;
	private boolean Leftswitch = false;
	private boolean Rightswitch = false;
	public static int charID;
	private boolean firstframe = true;
	public static boolean connected = true;
	public static String token = "3WnO1dobsqa2TCK";
	public static String username = "noah";
	public static String ip = "0123";
	
	
	public static Camera camera;
	public static String WorldArray[];
	
	
	public main(String gamename)
	{
		super(gamename);
	}
	//Create some base assets (Base:Map)
	
	
	//Rendering Hooks
	@Override
	public void init(GameContainer gc) throws SlickException {
		//Init Base map
		RenderINV.init();
		MainMenu.Init();
		ConnectionScreen.Init();
		logManager.init();
		MultiplayerRender.init();
		loginMenu.Init(gc);
		chatRender.Init();
		DefaultTileSet.init();
		//Give mods the ability to load.
		
		EventPublisher.raiseEvent(new ClientInitEvent());
		//grassMap = new TiledMap("assets/GrassMap.tmx");
		//camera = new Camera(gc, grassMap);
		img = new Image("assets/textures/Character.png");
		woodIcon = new Image("assets/textures/woodIcon.png");
}

		
	

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
	// Key input
		FrameCount++;
		if (FrameCount==1500){
			//logManager.LogDebug("doing WorldUpdate...");
			UpdateGrassMap();
			FrameCount=0;
			
		}
		
        up = gc.getInput().isKeyDown(Input.KEY_UP);
        down = gc.getInput().isKeyDown(Input.KEY_DOWN);
        left = gc.getInput().isKeyDown(Input.KEY_LEFT); 
        right = gc.getInput().isKeyDown(Input.KEY_RIGHT);
        use = gc.getInput().isKeyDown(Input.KEY_E);
        enter = gc.getInput().isKeyDown(Input.KEY_ENTER);
        
        if (Menu==0){
        //Only press once eatch frame (Stops crazy flying)
        if (up){
        	if(!(Upswitch)){
        		Upswitch=true;
        		moveCharUp();
        		
        	}
        	if((Upswitch)){
        		
        	}	
        }	
        if(!(up)){
        	Upswitch=false;
        }
        
        
        //Code, Sleep, Repeat
        if (down){
        	if(!(Downswitch)){
        		Downswitch=true;
        		movecharDown();
        	}
        	if((Downswitch)){
        		
        	}
        }
        if(!(down)){
        	Downswitch=false;
        }
        // End of line
       
        if (left){
        	if(!(Leftswitch)){
        		Leftswitch=true;
        		moveCharLeft();
        		
        		
        	}
        	if((Leftswitch)){
        		
        	}
        }
        if(!(left)){
        	Leftswitch=false;
        }
        if (right){
        	if(!(Rightswitch)){
        		Rightswitch=true;
        		moveCharRight();
        		
        		
        	}
        	if((Rightswitch)){
        		
        	}
        }
        if(!(right)){
        	Rightswitch=false;
        }
        }
        if (Menu==1){
            if (up){
            	if(!(Upswitch)){
            		Upswitch=true;
            		if (MainMenu.SelectedMenu==2){
            			MainMenu.SelectedMenu = 1;
            			System.out.println("Selected Menu option:" + MainMenu.SelectedMenu);
            		}
            	}
            	if((Upswitch)){
            		
            	}	
            }	
            if(!(up)){
            	Upswitch=false;
            }
            if (down){
            	if(!(Downswitch)){
            		Downswitch=true;
            		if (MainMenu.SelectedMenu==1){
            			MainMenu.SelectedMenu = 2;
            			System.out.println("Selected Menu option:" + MainMenu.SelectedMenu);
            	}
            	if((Downswitch)){
            		
            	}
            }
            if(!(down)){
            	Downswitch=false;
            }
        }
            if (enter){
            	if(!(enterswitch)){
            		enterswitch=true;
            		if (MainMenu.SelectedMenu==1){
            			Menu = 2;
            			serverStart.StartServer(5244);
            			mainClient.Connect("Localhost", 5244);
            			
            			//TODO remove server start code
            			
            		}
            	}
            	if((enterswitch)){
            		
            	}
            	
            	
            }
            if (!(enterswitch)){
            	enterswitch=false;
            }
        }
        if (Menu==5){
        	 if (enter){
             	if(!(enterswitch)){
             		enterswitch=true;
             		Menu=3;
             		//Now login to our server
             		try {
						//token=main.GetAuthKey(loginMenu.username, loginMenu.password);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						logManager.LogCrash(e.getStackTrace().toString());
					}
             		
             		if (token.equals("Error Logging in: Bad Login")){
             			Menu=5;
             			
             		}else{
             			serverStart.StartServer(5244);
            			mainClient.Connect("Localhost", 5244);
             		}
             		}
             	
             	if((enterswitch)){
             		
             	}
             	 if (!(enterswitch)){
                  	enterswitch=false;
                  }
        	 }
        	 
        }
        if (Menu==7){
       	 if (enter){
            	if(!(enterswitch)){
            		enterswitch=true;
            		//Send Chat Message to server.
            		
            		}
            	
            	if((enterswitch)){
            		
            	}
            	 if (!(enterswitch)){
                 	enterswitch=false;
                 }
       	 }
       	 
       }
             	
             
            
        }
        
        
        
	
		
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		if (Menu==0){
		use = gc.getInput().isKeyDown(Input.KEY_E);
		//camera.drawMap();
		camera.translateGraphics();
		//grassMap.render(0, 0);
		//System.out.println(grassMap.getTileId(2, 5, 0));
	    //grassMap.setTileId(2, 2, 0, 2);
	    if (use){
        //g.drawString(Integer.toString((grassMap.getTileId((CharX/32), (CharY/32),0))), 100, 100);
        
        }
	    //draw(0,0,gc);
		//Read map for render
		img.draw(CharX,CharY);
		MultiplayerRender.Render(gc, g);
		camera.centerOn(CharX,CharY);
		camera.untranslateGraphics();
		
		RenderINV.render(gc,g);
		timeRender.render(gc, g);
		chatRender.render(gc, g);
		}
		if (Menu==1){
			MainMenu.render(gc, g);
		}
		if (Menu==2){
			ConnectionScreen.render(gc, g);
		}
		if (Menu==5){
			loginMenu.render(gc, g);
		}
		
		
		
		
	}
	
	
	
	// Main Applet
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("Starting Plugin System...");
		pluginLoader.load();
		
		try
		{
			ip="0123";
			//String ipConnection = args[3];
			int Port = 2154;
			//System.out.println("Starting Direct Connect mode to " + ipConnection);
			//mainClient.Connect(ipConnection, 52143);
			
			
			//try {
				//ip = (InetAddress.getLocalHost().toString());
			//} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
			System.out.println("Found IP for token: " + ip);
			
			// Prepare playerObject
			//Player me = new Player();
			//me.AuthKey=args[1];
			//me.username=args[0];
			// Init
			AppGameContainer appgc;
			appgc = new AppGameContainer(new main("Survive!"));
			appgc.setDisplayMode(640, 480, false);
			appgc.setShowFPS(false);
			
			//ServerConnection.ConnectServer();
							
			appgc.start();
			connected = false;
		}
		catch (SlickException ex)
		{
			Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
		}
		}
		
			//connect to Delicated server on localhost!

	//}
	public static void moveCharUp(){
		if (!(CharY==0)){
    		CharY=(CharY-32);
    		//ServerConnection.GetWorldData(CharX, CharY);
    		moveChar(CharY,CharX);
		}
		
	}
	public static void movecharDown(){
		if (!(CharY==(32*100))){
    		CharY=(CharY+32);
    		System.out.println("Move to " + (CharY/32));
    		moveChar(CharY,CharX);
    		//ServerConnection.GetWorldData(CharX, CharY);
    		
    	}
		
	}
	public static void moveCharLeft(){
		if (!(CharX==0)){
    		CharX=(CharX-32);
    		System.out.println("Move to " + (CharX/32));
    		moveChar(CharY,CharX);
    		//ServerConnection.GetWorldData(CharX, CharY);
    	}
	}
	public static void moveCharRight(){
		if (!(CharX==32*100)){
    		CharX=(CharX+32);
    		System.out.println("Move to " + (CharX/32));
    		moveChar(CharY,CharX);
    		//ServerConnection.GetWorldData(CharX, CharY);
    	}
	}

	 public static void printMap(Map mp) {
		    Iterator it = mp.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pairs = (Map.Entry)it.next();
		        System.out.println(pairs.getKey() + " = " + pairs.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		}
	 
	public static void MoveNotification(int NewX, int NewZ){
		//Client client = noahp78.survive.client.ServerConnection.client;
	    //CharacterMovement request = new CharacterMovement();
	    //request.Xcor = NewX;
	    //request.Zcor = NewZ;
	    //request.CharID = charID;
	    //client.sendTCP(request);
	    //ServerConnection.GetWorldData(NewX,NewZ);
	    
		// start building of Packet
		

		
	}
	//public static void addtoMap(int X, int Y, int TILEID){
	//	m.put(XY, ID);
		//System.out.println(XY + " : " + ID);
		//System.out.println(X +","+Y+"," + TILEID);
		//grassMap.setTileId(X, Y, 0, TILEID);
		//System.out.println(X +","+Y+"," + TILEID);
		
	//}
	public static void UpdateGrassMap(){
		int x5 = -1;
		int y5 = -1;
		while( x5 < 100 ) {
			x5++;
			while (y5<100){
				y5++;
				String Combined = (y5 + ":" + x5);
				String ValueS =  (String) mainClient.TempWorldMap.get(Combined);
				if (ValueS!=null){
					int Value = Integer.parseInt(ValueS);
					WorldRender.AddTileToMap(TileRegistry.getTile(Value), x5, y5);
				}
					//grassMap.setTileId(x5, y5, 0, 2);

				
			}
			y5=-1;
			
	}
	 
	}
	public static void moveChar(int x, int y){
		x = x/32;
		y = y/32;
		mainClient.MovePlayer(x, y);
	}
	 public static String GetAuthKey(String Username, String string) throws Exception{
	    	String Tokens = string;	    	
	    	URLConnection connection = new URL("http://www.utopianworlds.tk/login.php?username=" + Username + "&pass=" + Tokens +"&IP=" + "0123").openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.connect();
			BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
			StringBuilder sb2 = new StringBuilder();
			String line;
			while ((line = r.readLine()) != null) {
			    sb2.append(line);
			}
			String Response = sb2.toString();
			System.out.println(Response);
			return Response;
	    }
	 public static void addWorldTile(int TileID){
		 
	 }
	

}
