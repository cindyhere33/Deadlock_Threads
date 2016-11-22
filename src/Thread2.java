
public class Thread2 extends Thread {

	public Thread2() {
		System.out.println("Thread2: Thread created");
	}

	@Override
	public void run() {
		while (true) {
			synchronized (ThreadDeadlock.lock2) {
				System.out.println("Thread2: Acquired lock2");
				try {
					Thread1.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread2: Waiting for lock1");
				synchronized (ThreadDeadlock.lock1) {
					System.out.println("Thread2: Acquired lock1");
				}
				System.out.println("Thread2: Released lock1 and lock2");
			}
		}
	}
}
