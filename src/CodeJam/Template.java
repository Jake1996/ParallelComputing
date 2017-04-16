package CodeJam;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Template {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		Task result[] = new Task[tc];
		while(tc--!=0) {
			//Input case related variables
			result[temp-tc-1] = new Task(temp-tc/* pass in case related variables*/);
			service.submit(result[temp-tc-1]);
		}
		in.close();
		service.shutdown();
		while(!service.isTerminated()) {}
		for (int i =0; i<temp; i++){
			System.out.println(result[i].output);
		}
	}
	static public class Task implements Runnable {
		private int taskId;
		// Add task related variables here

		public String output;
		public Task(int i /* add parameters for task related variables*/) {
			this.taskId = i;
			//Inititalize task related variables
		}
		@Override
		public void run() {
				/*
				 * Program code must come here for each individual test case	
				 */
				output = "Case #"+(taskId)+": ";//assign the output to the output variable
			}
		}

}
