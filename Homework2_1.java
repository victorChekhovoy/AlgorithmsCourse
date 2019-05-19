package algorithsCourse;

import java.util.Iterator;

public class Homework2_1 {
	public class RandQueue<Item> implements Iterable<Item>{
		private Item[] s;
		private int N = 0;
		public RandQueue() {
			s = (Item[]) new Object[1];		
			}
		public boolean isEmpty() {
			return N==0;
		}
		public int size() {
			return N;
		}
		public void enqueue(Item item) {
			s[++N] = item;
			
		}
		@Override
		public Iterator<Item> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
