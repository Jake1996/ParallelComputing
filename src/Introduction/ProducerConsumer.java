package Introduction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {
	public static AtomicInteger produce = new AtomicInteger(0);
	public static void main(String[] args) throws InterruptedException {
		int processors = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(processors);
    	for (int i =0; i<100; i++){
    		service.submit(new producer(i));
    		service.submit(new consumer(i));
    		System.out.println(i);
    	}
	}
	static class producer extends Thread {
		Thread t;
		int num;
		public producer(int n) {
			num = n;
		}
		public void run() {
			while(true) {
				System.out.println(produce.incrementAndGet()+" by "+this.getName());
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void start() {
			if(t==null) {
				t = new Thread(this,"Producer thread - "+num);
			}
			t.start();
		}
	}
	static class consumer extends Thread {
		Thread t;
		int num;
		public consumer(int n) {
			num = n;
		}
		public void run() {
			while(true) {
				System.out.println(produce.decrementAndGet()+" by "+this.getName());
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void start() {
			if(t==null) {
				t = new Thread(this,"Consumer thread - "+num);
			}
			t.start();
		}	
	}
 }

