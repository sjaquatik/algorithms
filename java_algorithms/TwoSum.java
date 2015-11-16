import java.util.TreeSet;
import java.util.SortedSet;
import java.util.Iterator;

public class TwoSum {
	
	private SortedSet<Integer> sortedSet;

	public TwoSum(){
		sortedSet = new TreeSet<Integer>();
	}
	
	public void store(int input){
		sortedSet.add( input );
	}

	boolean test(int val){
		Iterator<Integer> it = sortedSet.iterator();
		boolean status = false;
		while(it.hasNext() && !status){
			int currNum = it.next();
			status = sortedSet.contains(val - currNum) && 2*currNum !=val;
		}
		return status;
	}

	public static void main(String[] args){
		TwoSum twoSum = new TwoSum();
		twoSum.store(1);
		twoSum.store(-2);
		twoSum.store(3);
		twoSum.store(6);
		log("4?: " +  twoSum.test(4));
		log( "-1?: " + twoSum.test(-1));
		log("9? : " + twoSum.test(9));
		log("10? : " + twoSum.test(10));
		log("5? : " + twoSum.test(5));
		log("6?: "+ twoSum.test(6));
	}

	static void log(String str){
	System.out.println(str);
	}

}
