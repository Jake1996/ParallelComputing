package GraphAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DijikstraMain {
	public static void main(String args[]) throws InterruptedException {
		FastReader in = new FastReader();
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<ArrayList<edge>> g = new ArrayList<>();
		for(int i=0;i<n;i++) {
			g.add(new ArrayList<>());
		}
		int u,v,w;
		for(int i=0;i<m;i++) {
			u = in.nextInt()-1;
			v = in.nextInt()-1;
			w = in.nextInt();
			g.get(u).add(new edge(w, v));
		}
		in.close();
		long shortest[][] = new long[n][];
		int processors = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(processors*2);
    	Dijikstra d;
    	Dijikstra.graph = g;
		for (int i =0; i<n; i++){
			d = new Dijikstra(i);
    		service.execute(d);
    		shortest[i] = d.dist;
    	}
		service.shutdown();
		while(!service.isTerminated()) {}
		for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(shortest[i]));
		}
	}
	static class edge{
		long weight;
		int v;
		public edge(long w,int x) {
			weight = w;
			v = x;
		}
	}
	static class Dijikstra implements Runnable{
		public static ArrayList<ArrayList<edge>> graph;
		public long[] dist;
		public boolean[] visited;
		public int source;
		public Dijikstra(int source) {
			this.source = source;
			dist = new long[graph.size()];
			visited = new boolean[graph.size()];
			
		}
		@Override
		public void run() {
			for(int i=0;i<graph.size();i++) {
				dist[i] = Long.MAX_VALUE;
			}
			dist[source] = 0;
			PriorityQueue<edge> Q = new PriorityQueue<>(new Comparator<edge>() {
				@Override
				public int compare(edge o1, edge o2) {
					if(o1.weight-o2.weight>0) return 1;
					if(o1.weight-o2.weight<0) return -1;
					return 0;
				}
			});
			Q.add(new edge(0, source));
			edge ref;
			int u,v;
			long w;
			while(!Q.isEmpty()) {
				ref = Q.remove();
				//w = ref.weight;
				u = ref.v;
				if(visited[u]) continue;
				visited[u] = true;
				for(edge e:graph.get(u)) {
					//System.out.println("here");
					v = e.v;
					w = e.weight;
					if(dist[u] + w < dist[v]) {
						dist[v] = w + dist[u];
						Q.add(new edge(dist[v], v));
					}
				}
			}
		}

	}
}
