import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map.Entry;

public class ReverseDepthSum{
	
	private Map<Integer, List<Integer>> levelMap;
	private Integer maxLevel=0;
	private Integer nextLevelSum=0;
	private Integer depthSum=0;

	public ReverseDepthSum(List<NestedInteger> input){
		maxLevel = 1;
		this.levelMap = new HashMap<Integer, List<Integer>>();
		initLevelMap(input, this.levelMap, maxLevel);
		maxLevel += 1;
	}
	
	public int reverseDepthSum(){
		for (Entry<Integer, List<Integer>> entry : levelMap.entrySet()){
			int level = entry.getKey();
			List<Integer> value = entry.getValue();
			for(Integer i:value){
				this.depthSum = this.depthSum + level * i;
				this.nextLevelSum = this.nextLevelSum + this.maxLevel * i;
			}
		}

		return this.nextLevelSum - depthSum;
	}

	void print(){
		System.out.println("Map is: " + levelMap.toString() + " level is: " + maxLevel);
	}

	/* This collection maps each level to the individual Integer
           For example:  This { {1,1}, 2 , { 1, 1}} will be
	
	    Level(key)     ->      Integer(value)
	     	1 	   -> 	   [2]
	        2          ->      [ 1,1,1,1]
	*/
	public void initLevelMap(List<NestedInteger> input, Map< Integer,List<Integer>> levelMap, Integer currentLevel){
	
		// base case
		if(input == null){	
			return;
		}
	
		else{
			// iterate through all the NestedInteger in the list
			for (NestedInteger it: input){
				// if single integer
				if(it.isInteger()){
					if(!levelMap.containsKey(currentLevel))
					{
						levelMap.put(currentLevel, new LinkedList<Integer>());
					}
					levelMap.get(currentLevel).add(it.getInteger());
				}
				else{
				// recursive call
					initLevelMap(it.getList(), levelMap, maxLevel += 1);
				}
			}
		}
	
	}

	public static void main(String[] argvs){
		NestedInteger n6 = new NestedIntegerImpl(6);
		List<NestedInteger> l6= new LinkedList<NestedInteger>();
		l6.add(n6);
		NestedInteger nl6 = new NestedIntegerImpl(l6);

		NestedInteger n4 = new NestedIntegerImpl(4);

		List<NestedInteger> l4 = new LinkedList<NestedInteger>();
		l4.add(n4);
		l4.add(nl6);
		NestedInteger nn6 = new NestedIntegerImpl(l4);

		NestedInteger n1 = new NestedIntegerImpl(1);
		List<NestedInteger> ln1 = new LinkedList<NestedInteger>();
		ln1.add(n1);
		ln1.add(nn6);

		ReverseDepthSum rds = new ReverseDepthSum(ln1);
		rds.print();

		System.out.println("Revers sum is: " + rds.reverseDepthSum());
	}

}

interface NestedInteger{
	boolean isInteger();

	Integer getInteger();

	List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger{

	public NestedIntegerImpl(Integer myInt){
		this.myInteger = myInt;
		this.list = null;
	}

	public NestedIntegerImpl(List<NestedInteger> input){
		this.myInteger = null;
		this.list = input;
	}
	
	Integer myInteger;	

	List<NestedInteger> list;
	
	public boolean isInteger(){
		return this.myInteger != null;
	}
	
	public Integer getInteger(){
		if(this.isInteger()){
			return this.myInteger;
		}
		return null;
	}
	
	public List<NestedInteger> getList(){
		if (this.isInteger()){
			return null;
		}
		else{
			return this.list;
		}
	}

}

