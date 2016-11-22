
public class ThreadDeadlock {
	
	static Object lock1, lock2;
	
	public static void main(String args[]) throws Exception{
		lock1 = new Object();
		lock2 = new Object();
		new Thread1().start();
		new Thread2().start();
	}

}
