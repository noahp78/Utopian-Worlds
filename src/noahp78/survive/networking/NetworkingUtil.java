package noahp78.survive.networking;

import java.util.HashMap;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

import noahp78.survive.networking.*;
import noahp78.survive.networking.requests.*;
import noahp78.survive.networking.responses.*;


public class NetworkingUtil {
	
	static public void register (EndPoint endPoint) {
		Kryo kryo = endPoint.getKryo();
		//TODO add all the requests and responses
		kryo.register(authRequest.class);
		kryo.register(initRequest.class);
		kryo.register(initResponse.class);
		kryo.register(authResponse.class);
		kryo.register(gamedataRequest.class);
		kryo.register(gamedataResponse.class);
		kryo.register(String[].class);
		kryo.register(HashMap.class);
		kryo.register(moveRequest.class);
		kryo.register(moveResponse.class);
		kryo.register(playerJoinEvent.class);
		kryo.register(timeResponse.class);
		
		
	}
	

}
