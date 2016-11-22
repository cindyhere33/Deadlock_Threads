
class Thread1 extends Thread {

	public Thread1() {
		System.out.println("Thread1: Thread created");
	}

	@Override
	public void run() {
		while (true) {
			synchronized (ThreadDeadlock.lock1) {
				System.out.println("Thread1: Acquired lock1");
				try {
					Thread1.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread1: Waiting for lock2");
				synchronized (ThreadDeadlock.lock2) {
					System.out.println("Thread1: Acquired lock2");
				}
				System.out.println("Thread1: Released lock1 and lock2");
			}
		}
	}

}
