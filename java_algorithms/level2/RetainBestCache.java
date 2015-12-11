import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.AbstractMap;
public class RetainBestCache<K, T extends Rankable>{

	private int CACHE_SIZE = 100;
	private Map<K,T> cache;
	private DataSource<K, T> ds;
	private Queue<Map.Entry<K,T>> priorityQueue;
	private GenericComparator<K,T> genericComparator;

	public RetainBestCache( DataSource<K,T> ds, int entriesToRetain ){
		this.ds = ds;
		this.CACHE_SIZE = entriesToRetain;
		genericComparator = new GenericComparator<K,T>();
		priorityQueue = new PriorityQueue<Map.Entry<K,T>>(this.CACHE_SIZE, genericComparator);
		
	}

	public T get(K key){
		// get from cache
		T obj = cache.get(key);
	
		// handle cache miss
		if(obj == null){
			// get from DataSource
			obj = this.ds.get(key);
			// update cache and priorityQueue;
			handleCacheMiss(key, obj);
		}
		return obj;
	}

	public static void main(String[] args){}

	/**
		1. update priority queue
		2. update cache
	*/
	public void handleCacheMiss(K key, T value){
		// Evict lowest lowest object from priority queue
		// add K key and T value
		Map.Entry<K,T> evicted  = updateQueue(key, value);
		updateCache(key, value, evicted);
		
	}

	/**
		1. evict T with large getRank()
		2. update queue with T returned from DataSource
		3. return T that was evicted
	*/
	public Map.Entry<K,T> updateQueue(K key, T value){
		Map.Entry<K, T> newObject = new AbstractMap.SimpleEntry<K,T>(key, value);
                priorityQueue.add(newObject);
		if(priorityQueue.size() < CACHE_SIZE){
			priorityQueue.add(newObject);
			return null;
		}
		else{
			Map.Entry<K,T> evicted = priorityQueue.poll();
			priorityQueue.add(newObject);
			return evicted;
		}
			
	}
	
	public void updateCache(K key, T value, Map.Entry<K,T> evicted){
		if(evicted != null){
			cache.remove( evicted.getKey() );
		}
		cache.put(key,value);
	}

}

/////////// INTERFACE /////////////////
interface Rankable{
	long getRank();
}

interface DataSource<K, T>{
	T get(K key);
}

class GenericComparator<K, T extends Rankable> implements Comparator<Map.Entry<K, T>>{
	 public int compare(Map.Entry<K, T> o1, Map.Entry<K, T> o2) {

	 long o2Rank = o2.getValue().getRank();
	 long o1Rank = o1.getValue().getRank();
	
   	if( o2Rank > o1Rank ){
	return 1;
	}
	else if ( o2Rank == o1Rank){
		return 0;
	}
	else{
		return -1;
	}
    }
   
}
