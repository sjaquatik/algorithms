/**All elements in TrungSet is unique
*/
import java.util.Hashtable;
import java.util.Vector;
import java.util.Map;
import java.util.Set;
import java.util.Random;
public class TrungSet<E>{
	private Vector<E> myVector;
	private Hashtable<E, Integer> table;
	
	public TrungSet(){
		myVector = new Vector<E>();
		table = new Hashtable<E, Integer>();
	}
	
	public static void main(String[] args){
		TrungSet<String> set = new TrungSet<String>();
		set.insert("bidder01");
		set.insert("bidder02");
		set.insert("bidder03");
		set.print();
		log( " A random element: " + set.getRandomElement());
		set.remove("bidder02");
		set.print();
		log( " A random element: " + set.getRandomElement());
	}
	
	private void print(){
		log("Vector");
		printVector();
		log("table");
		printTable();
	}

	private void printTable(){
		Set<Map.Entry<E, Integer>> entrySet = table.entrySet();
		for( Map.Entry<E, Integer> entry : entrySet){
			log( entry.getKey().toString() + "-->" + entry.getValue().toString());
		}
	}

	private void printVector(){
		for( E e : myVector){
			log(e.toString());
		}
	}

	/**
	*/
	public void insert(E e){
		if( !table.containsKey(e)){
			addToVectorTail(e);
			table.put(e, getVectorTail());
		} else{
			log("not adding " + e.toString() + " because it is already in the set");
		}	
		
	}

	/**
	*/
	public void remove(E e){
		if( table.containsKey(e)){
			Integer indexOfRemoveElement = table.get(e);
			E updatedElem = swapEndOfVector(indexOfRemoveElement);
			removeFromTable(e);
			updateTable( updatedElem, indexOfRemoveElement);
			truncateVectorTail();
			
		} else {
			log("Element " + e.toString() + " is not in the set");
		}
	}

	private Integer getVectorTail(){
		if (myVector.isEmpty()){
			return 0;
		}
		else{
			return (myVector.size() - 1);
		}
	}

	/**
	*/
	public E getRandomElement(){
		Random r = new Random();
		int random = r.nextInt(myVector.size());
		return myVector.get(random);
	} 

	public static void log(Object msg){
		System.out.println(msg.toString());
	}

	public void addToVectorTail(E elem){
		myVector.add(elem);
	}

	public E swapEndOfVector(Integer index){
		if( myVector.size() > 1 ){
		E elemAtIndex = myVector.get(index);
		E lastElement = myVector.lastElement();
		myVector.set( index, lastElement);
		myVector.set( getVectorTail() , elemAtIndex);
		return lastElement;
		}
		else{
			return null;
		}
		
	}
	private void removeFromTable(E elem){
		table.remove(elem);
	}
	private void updateTable( E elem, Integer index){
		if (elem != null){
		table.put( elem, index);
		}
		else{
			table.clear();
		}
	}
	private void truncateVectorTail(){
		int tail = getVectorTail();
		myVector.remove( tail );
	}
}

