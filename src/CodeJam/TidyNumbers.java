package CodeJam;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * https://code.google.com/codejam/contest/3264486/dashboard#s=p1
 * @author jake
 *
 */
public class TidyNumbers {
	public static void main(String args[]) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		Task result[] = new Task[tc];
		while(tc--!=0) {
			char no[] = in.next().toCharArray();
			result[temp-tc-1] = new Task(temp-tc, no);
			service.submit(result[temp-tc-1]);
		}
		in.close();
		service.shutdown();
    	while(!service.isTerminated()) {}
		for (int i =0; i<temp; i++){
			System.out.println(result[i].output);
		}
	}
	static public class Task implements Runnable{
		private int taskId;
		public char no[];
		public String output;
		public Task(int i,char[] a) {
			this.taskId = i;
			this.no = a;
		}
		
		@Override
		public void run() {
			for(int i=no.length-1;i>0;i--) {
				if(no[i]<no[i-1]) {
					no[i-1]--;
					for(int j=i;j<no.length;j++) no[j] = '9';
				}
			}
			long k = Long.parseLong(new String(no));
			output = "Case #"+(taskId)+": "+k;
		}	
	}
}
