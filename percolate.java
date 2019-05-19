package algorithsCourse;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
	
	public class percolate{
		public class UF{
			
			private int[] id;
			private int[] sz;
			
			public UF(int N) 
			{
				id = new int[N];
				sz = new int[N];
				for (int i = 0; i < N; i++) 
				{
					sz[i] = 1;
					id[i] = i;
				}
			}
			public int root(int p) {
				int i = 0;
				while (id[i] != i) {
					i = id[i];
				}
				return i;
			}
			public boolean connected(int p, int q)
			{
				return (root(p) == root(q));
			}
			public void unite(int p, int q) {
				if (sz[p] < sz[q]) {id[root(p)] = root(q); sz[root(q)] += sz[root(p)];}
				else {id[root(q)] = root(p); sz[root(p)] += sz[root(q)];}
			}
		}
		public static void main(String[] args) {
			int N = StdIn.readInt();
			for(int i = 0; i < N; i++) {
				
			}
		}
}
