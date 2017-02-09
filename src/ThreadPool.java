import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool{

    public static void main(String args[]) {
       ExecutorService service = Executors.newFixedThreadPool(5);
       for (int i =0; i<100; i++){
           service.submit(new Task(i));
       }
    } 
}

final class Task implements Runnable{
    private int taskId;
  
    public Task(int id){
        this.taskId = id;
        System.out.println("New task : "+this.taskId+" created by "+Thread.currentThread().getName());
    }
  
    @Override
    public void run() {
        System.out.println("Task ID : " + this.taskId +" performed by " 
                           + Thread.currentThread().getName());
        int l=2;
        for(long i = 0; i < 1000000; i++) {
        	for(long j = 0; j < 1000000; j--) {
        		//System.out.println("Thread: " + threadNo + ", " + i);
        		l*=2;
        	}
        }
    }
  
}