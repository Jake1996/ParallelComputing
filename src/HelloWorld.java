/**
 * Program that creates two threads that count from 200 to 0 in reverse
 * @author jake
 *
 */
public class HelloWorld {
	static class ThreadDemo extends Thread {
		private Thread t;
		private int threadNo;

		ThreadDemo( int id) {
			threadNo = id;
			System.out.println("Creating " +  id );
		}

		public void run() {
			System.out.println("Running " +  threadNo );
			for(int i = 200; i > 0; i--) {
				System.out.println("Thread: " + threadNo + ", " + i);
			}
			System.out.println("Thread " +  threadNo + " exiting.");
		}

		public void start () {
			System.out.println("Starting " +  threadNo );
			if (t == null) {
				t = new Thread (this, threadNo+"");
				t.start ();
			}
		}
	}

	public static void main(String args[]) {
		ThreadDemo T1 = new ThreadDemo(1);
		T1.start();

		ThreadDemo T2 = new ThreadDemo(2);
		T2.start();
	}   
}