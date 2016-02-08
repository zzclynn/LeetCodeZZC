import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class PhoneNumber {
	public static List<String> letterCombinations(String digits) {
		Map<Character, char[]> map = new HashMap<Character, char[]>();
	    map.put('0',  " ".toCharArray());
	    map.put('1',  null);
	    map.put('2',  "abc".toCharArray());
	    map.put('3',  "def".toCharArray());
	    map.put('4',  "ghi".toCharArray());
	    map.put('5',  "jkl".toCharArray());
	    map.put('6',  "mno".toCharArray());
	    map.put('7',  "pqrs".toCharArray());
	    map.put('8',  "tuv".toCharArray());
	    map.put('9',  "wxyz".toCharArray());

	    char[] digs = digits.toCharArray();
	    int len = digs.length;
	    int[] pos = new int[len+1];
	    char[] combination = new char[len];
	    List<String> result = new LinkedList<String>();

	    while (pos[len] == 0) {
	        // Compose string
	        for (int i=0; i<len; i++) {
	            combination[i] = map.get(digs[i])[pos[i]];
	        }
	        result.add(new String(combination));

	        // Iterate
	        pos[0]++;
	        for (int i=0; i<len; i++) {
	            if (pos[i] == map.get(digs[i]).length) {
	                pos[i] = 0;
	                pos[i+1]++ ;
	            } else {
	                break;
	            }
	        }
	    } 

	    return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result= letterCombinations("1234");
	}

}
