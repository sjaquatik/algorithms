import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
public class Isomorphic{
	public static void main(String[] args){
		log("Is ismorphic?: " + isIsomorphic("turtle", "tletur"));
	}
	static boolean isIsomorphic(String str1, String str2){
		if( str1 == null || str2 == null){
			return false;
		}
		else if( str1.length() != str2.length() ){
			return false;
		}
		else if( str1.length() < 2 ){
			return true;
		}
		else{
			char[] firstCharArray = str1.toCharArray();
			char[] secCharArray = str2.toCharArray();
			Map<Character, Character> isoMap = new HashMap<Character, Character>();
			Map<Character, Character> isoMapRev = new HashMap<Character, Character>();
			for(int i = 0; i < str1.length(); i++ ){
				Character aCharFromFirst = firstCharArray[i];
				Character aCharFromSec = secCharArray[i];
			
				// not mapped
				if( isoMap.get(aCharFromFirst) == null){
					if( isoMapRev.get(aCharFromSec) != null ){
						return false;
					}
					else{
						isoMap.put( aCharFromFirst, aCharFromSec);
						isoMapRev.put( aCharFromSec, aCharFromFirst);
					}
				// mapped
				} else {
						
					if( aCharFromSec != isoMap.get(aCharFromFirst) || aCharFromFirst != isoMapRev.get(aCharFromSec)){
						return false;
					}
					
				}
			} // end of for loop
		}
		return true; 
	}

	static void log(Object msg){
		System.out.println( msg.toString() );
	}

	static Set<Set<String>> isomorphicGroups(String[] words){
		Map<String, List<Integer>> digests = new HashMap<String, List<Integer>>();
		Map<Character, Integer> seen = new HashMap<Character, Integer>();
		
		for(String s: words){
			seen.clear();
			digests.put(s, new ArrayList<Integer>());
			for(char c : s.toCharArray()){
				if ( !seen.containsKey(c)){
					seen.put(c, seen.size());
				}
				digests.get(s).add(seen.get(c));
			}
		} // end for loop

		Map<List<Integer>, Set<String>> groupings = new HashMap<List<Integer>, Set<String>>();
		for( String k : digests.keySet()){
			List<Integer> v = digests.get(k);
			if( !groupings.containsKey(v)){
				groupings.put(v, new HashSet<String>());
			}
			groupings.get(v).add(k);		
		}
	return new HashSet<Set<String>>( groupings.values());	
}

}
