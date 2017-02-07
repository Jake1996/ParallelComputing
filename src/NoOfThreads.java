
public class NoOfThreads {
	public static void main(String args[]) throws InterruptedException {
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.print(cores);
		ThreadDemo t[] = new ThreadDemo[126];
		ThreadGroup tg = new ThreadGroup("theATeam");
		for(int i=0;i<126;i++) {
			t[i] = new ThreadDemo(i, tg);
			t[i].start();
		}
		System.out.println(tg.activeCount());
		for(int i=0;i<126;i++) {
			System.out.println(tg.activeCount());
			t[i].join();
		}
	}
	static class ThreadDemo extends Thread {
		private Thread t;
		private int threadNo;
		private ThreadGroup tg;
		ThreadDemo( int id,ThreadGroup t) {
			threadNo = id;
			System.out.println("Creating " +  id );
			tg = t;
		}

		public void run() {
			System.out.println("Running " +  threadNo );
			int l=2;
			for(long i = 0; i < 1000000; i++) {
				for(long j = 0; j < 1000000; j--) {
				//System.out.println("Thread: " + threadNo + ", " + i);
					l*=2;
				}
			}
			System.out.println("Thread " +  threadNo + " exiting.");
		}

		public void start () {
			System.out.println("Starting " +  threadNo );
			if (t == null) {
				t = new Thread(tg,this, threadNo+"");
				t.start ();
			}
		}
	}
}
