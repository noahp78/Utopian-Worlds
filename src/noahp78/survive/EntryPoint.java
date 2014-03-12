package noahp78.survive;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class EntryPoint {
	//Main applet, Start using this baby!
	public static void main(String[] args){
		System.out.println("Utopian Worlds - Preparing Libaries");
		System.out.println("Starting Download of slick2d from mirror");
		
		
		
	}
	public static void Downloadfile(String Location,String SaveLocation) throws Exception{
		URL website = new URL(Location);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream(SaveLocation);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	}
}
