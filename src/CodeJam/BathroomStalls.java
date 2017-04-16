package CodeJam;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://code.google.com/codejam/contest/3264486/dashboard#s=p2
 * @author jake
 *
 */
public class BathroomStalls {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		Task result[] = new Task[tc];
		while(tc--!=0) {
			long n = in.nextLong();
			long k = in.nextLong();
			result[temp-tc-1] = new Task(temp-tc, n,k);
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
		long n,k;
		public String output;
		public Task(int i,long n,long k) {
			this.taskId = i;
			this.n = n;
			this.k = k;
		}
		@Override
		public void run() {
			n-= (k-largestPower(k));
			k = largestPower(k);
			n /= k; 
			long l,r;
			n--;
			int add = 0;
			if(n%2==1) {
				add = 1;
			}
			l = r = n>>1;

					output = "Case #"+(taskId)+": "+(l+add)+" "+r;
			}
		}
	public static long largestPower(long n){
		int count = 0;
		while(n!=1) {
			n=n>>1;
			count++;
		}
		return (long)Math.pow(2, count);
		//		n = n|(n>>1);
		//		n = n|(n>>2);
		//		n = n|(n>>4);
		//		n = n|(n>>8);
		//		return (n+1)>>1;
	}
}
