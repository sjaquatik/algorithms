import java.util.Arrays;
import java.util.List;
public class MaxProduct{

	public static int maxProduct(List<Integer> inputList){
		int maxLocal = inputList.get(0);
		int minLocal = inputList.get(0);
		int global = inputList.get(0);
				
		for(int i = 1; i < inputList.size(); i++){
			int temp = maxLocal;
			int currNum = inputList.get(i);
			maxLocal = Math.max(Math.max(currNum*maxLocal, currNum*minLocal), currNum);  
        		minLocal = Math.min(Math.min(currNum*temp, currNum*minLocal), currNum);  
			log("currNum: " + currNum + " maxLocal: " + maxLocal + " minLocal: " + minLocal + " temp: " + temp);
        		global = Math.max(global, maxLocal);
		}
		return global;
	}

	static void log(Object msg){
		System.out.println(msg.toString());
	}
	
	public static void main(String[] args){
		List<Integer> list = Arrays.asList(-1, -2, -3, 5);
		//List<Integer> list = Arrays.asList(6, -3, -10, 0, 2);
		//List<Integer> list = Arrays.asList(-1, -3, -10, 0, 60);
		//List<Integer> list = Arrays.asList(-2, -3, 0, -2, -40);
		log("Max product: " + maxProduct(list));	
	}

}
