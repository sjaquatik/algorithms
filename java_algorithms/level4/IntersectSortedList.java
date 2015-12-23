import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
public class IntersectSortedList{

	public static void main(String[] args){
	
		List<Integer> l1 = new LinkedList<Integer>();
		l1.add(3);
		
		List<Integer> l2 = new LinkedList<Integer>();
		l2.add(3);
		l2.add(6);
		l2.add(8);
		l2.add(9);
		l2.add(12);

		List<Integer> intersectList = getIntersect(l1,l2);

		printList(intersectList);
	
	}
	
	static void printList(List<Integer> l){
		StringBuilder strBuilder = new StringBuilder();
		for(Integer i : l){
			strBuilder.append( i + " ---> " );
		}
		log( strBuilder.toString());
	}
	public static List<Integer> getIntersect(List<Integer> list1, List<Integer> list2){
		List<Integer> result = new LinkedList<Integer>();
		Iterator<Integer> i1 = list1.iterator();
		Iterator<Integer> i2 = list2.iterator();
		Integer int1 = i1.hasNext() ? i1.next() : null;
		Integer int2 = i2.hasNext() ? i2.next() : null;
		while( int1 != null && int2 != null){

			while( int1 < int2 && int1 != null){
				int1 = i1.hasNext() ? i1.next() : null;
			}			
			while( int2 < int1 && int2 != null){
				int2 = i2.hasNext() ? i2.next() : null;
			}
			if( int1 != null && int2 != null && int1.equals(int2)){
				result.add(int1);
				int1 = i1.hasNext() ? i1.next() : null;
				int2 = i2.hasNext() ? i2.next() : null;
			}

		}
		return result;
	}

	static void log(Object msg){
		System.out.println(msg.toString());
	}
}
