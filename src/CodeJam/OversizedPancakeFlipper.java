package CodeJam;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://code.google.com/codejam/contest/3264486/dashboard#s=p0
 * @author jake
 *
 */
public class OversizedPancakeFlipper {
	public static void main(String args[]) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		Task result[] = new Task[tc];
		while(tc--!=0) {
			char no[] = in.next().toCharArray();
			int s = in.nextInt();
			result[temp-tc-1] = new Task(temp-tc, no,s);
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
		char arr[];
		int s;
		public String output;
		public Task(int i,char[] a,int s) {
			this.taskId = i;
			this.arr = a;
			this.s = s;
		}
		@Override
		public void run() {
				int count=0;
				for(int i=0;i<=arr.length-s;i++) {
					if(arr[i]=='-') {
						count++;
						for(int j=i;j<i+s;j++) {
							arr[j] = arr[j]=='-'?'+':'-';
						}
					}
				}
				boolean check = true;
				for(int i=arr.length-s;i<arr.length;i++) {
					if(arr[i]=='-') {
						check = false;
						break;
					}
				}
				if(check) {
					output = "Case #"+(taskId)+": "+count;
				}
				else {
					output = "Case #"+(taskId)+": IMPOSSIBLE";				
				}
			}

		}

	}
