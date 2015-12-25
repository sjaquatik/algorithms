import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public class IntervalCoverage implements Intervals{
	
	public static void main(String[] args){
			IntervalCoverage client = new IntervalCoverage();
			client.addInterval(3,6);
			client.addInterval(8,9);
			client.addInterval(1,6);
			log("Interval coverage: " + client.getTotalCoveredLength());
	}

	static void log( Object msg ){
		System.out.println( msg.toString() );
	}

	private List<Integer> unionList;
	
	// constructor
	public IntervalCoverage(){
		unionList = new LinkedList<Integer>();
	}
	
	public void addInterval(int from, int to){

		List<Integer> newList = generateList( from, to );
		unionList = unionList( unionList, newList );

	}

	public int getTotalCoveredLength(){
		int result = 0;
		Integer[] unionArray = unionList.toArray( new Integer[unionList.size()] );
		for(int i = 0 ; i < unionArray.length - 1; i++){
			int currNum = unionArray[i];
			int nextNum = unionArray[i+1];
			int diff = nextNum - currNum;
			if(  diff == 1 ){
				result += 1;
			}
		}
		return result;
	}

	private List<Integer> generateList( int start, int end){
		List<Integer> resultList = new LinkedList<Integer>();
		if( end <= start || start < 0 ){
			return resultList;
		}
		for(int i = start; i <= end; i ++){
			resultList.add(i);
		}
		return resultList;
	}

	/** Union of two sorted integer list
	*/
	private List<Integer> unionList(List<Integer> l1, List<Integer> l2){
		Iterator<Integer> l1It = l1.iterator();
		Iterator<Integer> l2It = l2.iterator();
		// List to store result
		List<Integer> result = new LinkedList<Integer>();
		Integer i1 = l1It.hasNext() ? l1It.next() : null;
		Integer i2 = l2It.hasNext() ? l2It.next() : null;
		while( i1 != null && i2 != null){
			while( i1 != null && i1 < i2 ){
				result.add(i1);
				i1 = l1It.hasNext() ? l1It.next() : null;
			}
			while ( i2 != null && i1 != null && i2 < i1 ){
				result.add(i2);
				i2 = l2It.hasNext() ? l2It.next() : null;
			}
			if( i1 != null && i2!= null && i1.equals(i2)){
				result.add(i1);
				i1 = l1It.hasNext() ? l1It.next() : null;
				i2 = l2It.hasNext() ? l2It.next() : null;
			}
		}
	
		// Add the rest of the list
		while( i1 != null ){
			result.add(i1);
			i1 = l1It.hasNext() ? l1It.next() : null;
		}	
		while( i2 != null ){
			result.add(i2);
			i2 = l2It.hasNext() ? l2It.next() : null; 
		}
		return result;
	}// end of union list

}

interface Intervals{

	void addInterval(int from, int to);

	int getTotalCoveredLength();

}
