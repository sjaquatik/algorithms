import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class Pagination{
	public static void main(String[] args){
		String str = "The Wat is a royal temple categorized as Class III, which was built at the beginning of the Ayutthaya period, and was originally called Wat Rai Phrik (meaning in Thai language:\"Vegetable\"). It was so named as its location was within a vegetable garden.[1] The land where the temple is situated was provided by King Rama I to accommodate the prisoners of war.[3] The King Rama VI Vajiravudh got it refurbished by Chao Inthawong, where after it has been known as Wat Intharavihan.[1] Chao Inthwong also brought a priest from Vientianne to preside as the abbot of the temple. The temple then was given a new name as Chai Inthawong";
			List<String> result = Paginate(str, 38);
			for(String s: result){
				log(s);
			}
	} 
		/**
			Break a long input string into a single sentences of lineLength or shorter
		*/
	public static List<String> Paginate( String input, int lineLength){
			List<String> result = new ArrayList<String>();
			List<String> wordList = Arrays.asList(input.split("\\s"));
			Iterator<String> wordIter = wordList.iterator();
			int curLen = 0;
			List<String> currSentenceList = new ArrayList<String>();
			while( wordIter.hasNext() ){
				String curWord = wordIter.next();
				curLen += curWord.length() + 1;
				if( curLen <= lineLength){
					currSentenceList.add(curWord);
				}
				else{
					result.add( addSpaces(currSentenceList) );	
					curLen = curWord.length() + 1;
					currSentenceList = new ArrayList<String>();
					currSentenceList.add(curWord);
				}
			}
			if( currSentenceList != null && currSentenceList.size() > 0){
				result.add( addSpaces(currSentenceList) );
			}
			return result;
		}
	

	static String addSpaces( List<String> sentence){
		StringBuilder strBuilder = new StringBuilder();
		for( int i = 0; i < sentence.size() - 1; i++){
			strBuilder.append( sentence.get(i));
			strBuilder.append(" ");
		}
		strBuilder.append( sentence.get(sentence.size() - 1));
		return strBuilder.toString();
	}

	static void log(Object msg){
		System.out.println(msg.toString());
	}
	
}
