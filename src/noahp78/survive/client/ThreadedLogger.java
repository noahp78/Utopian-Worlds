package noahp78.survive.client;

public class ThreadedLogger implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("I'm A NEW THREAD :O With ID" + Thread.currentThread().getId());
		
		//System.out.println(ServerConnection.TempArray);
		
	}
	

}
