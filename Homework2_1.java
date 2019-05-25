package algorithsCourse;
import java.util.Random;
import java.util.Iterator;
import java.util.Arrays;
public class Homework2_1 {
	public static class RandQueue<Item> implements Iterable<Item>{
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
		public void shuffle(Item[] arr) {
			Random rand1 = new Random();
			//Item[] sCopy = s;
			int len = arr.length;
			for (int i = 0; i < len; i ++) {
				int r = rand1.nextInt(i + 1);
				Item temp = arr[r];
				arr[r] = arr[i];
				arr[i] = temp;
			}
		}
		private void resize(int capacity) {
			Item[] copy = (Item[]) new Object[capacity];
			for (int i = 0; i < N; i++) {
				copy[i] = s[i];}
			s = copy;
		}
		public void enqueue(Item item) {
			s[N++] = item;
			int cap = s.length;
			if (N == cap) {
				resize(cap * 2);
			}
			
		}
		public Item dequeue() {
			if (N > 0) {
				s = Arrays.copyOfRange(s, 0, N);
				shuffle(s);
				Item ret = s[--N];
				int cap = s.length;
				if (N < cap/4) {
					resize(cap/2);
				}
				return ret;
			}
			else { return null;}
		}
		public Item sample() {
			shuffle(s);
			return s[N];
		}
		
		
		public Iterator<Item> iterator() {
			return new RandQueueIterator();
		}
		
		private class RandQueueIterator implements Iterator<Item>{
			int cur = 0;
			Item[] curS = s;
			public boolean hasNext() {
				return (cur < N);
			}	
			public Item next() {
				if (cur == 0) {
					curS = Arrays.copyOfRange(curS, 0, N);
					shuffle(curS);
					}
				return curS[cur++];
			}
			
		}
		
	}
	
	}


