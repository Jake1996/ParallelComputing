public class ArraySum {
    public static void main(String args[]) {
        int n = 10000;
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = (int )(Math.random() * 1000 + 1);;
        }
        int sum=0;
        

        /* === OMP CONTEXT === */
class OMPContext {
	public int local_n;
	public int local_sum[];
	public int local_arr[];
}
final OMPContext ompContext = new OMPContext();
ompContext.local_n = n;
ompContext.local_arr = arr;
final org.omp4j.runtime.IOMPExecutor ompExecutor = new org.omp4j.runtime.DynamicExecutor(Runtime.getRuntime().availableProcessors());
/* === /OMP CONTEXT === */
ompContext.local_sum = new int[Runtime.getRuntime().availableProcessors()];
for (int ompK = 0; ompK < Runtime.getRuntime().availableProcessors(); ompK++) {/*!!!*/
	ompContext.local_sum[ompK]= new Integer(0);
}
for(int i_E5n=0;i_E5n<ompContext.local_n;i_E5n++) {	final int i = i_E5n;
	ompExecutor.execute(new Runnable(){
		@Override
		public void run() {

            ompContext.local_sum[ompExecutor.getThreadNum()]+=ompContext.local_arr[i];
        	}});
}ompExecutor.waitForExecution();
for (int ompK = 0; ompK < Runtime.getRuntime().availableProcessors(); ompK++) {/*!!!*/
	sum+=ompContext.local_sum[ompK];
}
        System.out.println(sum);
    }
}