import java.util.concurrent.locks.ReentrantLock;
import java.util.LinkedList;
import java.util.ArrayList;
public class MyHashTable<K,V>{
		
		public final int CAPACITY = 1000;
		private final ArrayList<LinkedList<Node>> buckets = new ArrayList<LinkedList<Node>>(CAPACITY);
		private final ArrayList<ReentrantLock> bucketLock = new ArrayList<ReentrantLock>(CAPACITY);
		
		public MyHashTable(){
			for(int i = 0; i < CAPACITY; i++){		
				bucketLock.add( new ReentrantLock());
				buckets.add(null);
			}
		}

		public static void main(String[] args){
		}		
		public V get(K key){
			try{
				LinkedList<Node> listOfEnries = lockAndGetList(key);
				for( Node n : listOfEnries){
					if(n.key.equals(key)){
						return n.value;
					}
				}
			return null;
			}
			finally{
				unlockBucket(key);
			}
		}
		
		public void put(K key, V value){
		}

	private LinkedList<Node> lockAndGetList(K key){
		int hashCode = key.hashCode();
		int bucketIndex = Math.abs( hashCode % CAPACITY);
		bucketLock.get(bucketIndex).lock();
		LinkedList<Node> bucket = buckets.get(bucketIndex);
		if(bucket == null){
			bucket = new LinkedList<Node>();
			buckets.set(bucketIndex, bucket);
		}
		return bucket;
	}
	private void unlockBucket(K key){
	
		int hashCode = key.hashCode();
		int bucketIndex = Math.abs( hashCode % CAPACITY);
		bucketLock.get(bucketIndex).unlock();
	
	}

	private class Node{
		K key;
		V value;
		private Node(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
	
}
