package GraphAlgorithms;
import java.util.Arrays;

public class FloydWarshallMain {
	public static void main(String args[]) {
		FastReader in = new FastReader();
		int n = in.nextInt();
		int m = in.nextInt();
		int g[][] = new int[n][n];
		int u,v,w;
		for(int i=0;i<m;i++) {
			u = in.nextInt()-1;
			v = in.nextInt()-1;
			w = in.nextInt();
			g[u][v]=w;
		}
		in.close();
		long ti1 = System.nanoTime();
		long shortest[][] = floydwarshall(g);
		long ti2 = System.nanoTime();
		System.out.println(ti2-ti1);
		//		for(int i=0;i<n;i++) {
//			System.out.println(Arrays.toString(shortest[i]));
//		}
	}
	public static long[][] floydwarshall(int arr[][]) {
		int n = arr.length;
		long dist[][] = new long[n][n];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i==j) continue;
				if(arr[i][j]==0) dist[i][j]=Long.MAX_VALUE;
				else dist[i][j] = arr[i][j];
			}
		}
		for(int k = 0; k < n; k++){
			for(int i = 0; i < n; i++){
				if(dist[i][k]!=Long.MAX_VALUE) {
					for(int j = 0; j < n; j++){
						if(dist[k][j]!=Long.MAX_VALUE){
							dist[i][j] = Math.min( dist[i][j], dist[i][k] + dist[k][j] );
						}
					}
				}
			}
		}
		return dist;
	}
}