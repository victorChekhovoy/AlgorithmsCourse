package algorithsCourse;

import java.util.Iterator;

public class Homework2 {
	
	public static class Deque <Item> implements Iterable<Item>{
		private Node first = null;
		private Node last = null;
		private int size = 0;
		private class Node{
			Item item;
			Node next;
			Node prev;
		}
		public boolean isEmpty(){
			return (first == null);
		}
		
		public void addFirst(Item item) {
			size++;
			Node oldfirst = first;
			first = new Node();
			first.item = item;
			first.prev = oldfirst;
			try {oldfirst.next = first;}
			catch (java.lang.NullPointerException e) {

			}
			
			if (first.prev == null)  { 
				last = first;
			}
		}
		
		public void addLast(Item item) {
			size++;
			Node oldlast = last;
			last = new Node();
			last.item = item;
			last.prev = oldlast;
			oldlast.next = last;
			if (last.prev == null) {
				first = last;
			}
		}
		
		public Item removeFirst() {
			size--;
			Item item = first.item;
			first = first.next;
			if (first == null) {
				last = null;
			}
			return item;
		}
		
		public Item removeLast() {
			size--;
			Item item = last.item;
			last = last.prev;
			if (last == null) {
				first = null;
			}
			return item;
		}
		
		public int size() {
			return size;
		}

		@Override
		public Iterator<Item> iterator() {
			
			return new DequeIterator();
		}
		
		private class DequeIterator implements Iterator<Item>{
			Node cur = first;
			public boolean hasNext() {
				return cur != null;
			}
			public Item next() {
				Item item = cur.item;
				cur = cur.next;
				return item;
			}
		}
	}
	
	public static void main(String[] args) {
		Deque<String> test = new Deque<String>();
		String insert1 = "www";
		test.addFirst(insert1);
		System.out.println(test.removeLast());
		
	}
}	
