package Introduction;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Program that creates a pool of threads and submits task to these threads
 * Helps remove overhead of creating a new thread for every job
 * @author jake
 *
 */
public class ThreadPool{

    public static void main(String args[]) {
    	int processors = Runtime.getRuntime().availableProcessors();
    	ExecutorService service = Executors.newFixedThreadPool(processors);
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
    }
  
}