import java.util.HashMap;
import java.util.Map;


public class RomantoInteger {
    public static int romanToInt(String s) {
    	int lenght=s.length();
    	int result=ElementCovert(s.charAt(lenght-1));
    	for(int i=lenght-2;i>=0;i--){
    		result+=negative(s.charAt(i),s.charAt(i+1))*ElementCovert(s.charAt(i));
    	}
        return result;
    }
    
    public static int negative(char current, char pre){
    	int negative=1;
    	if(ElementCovert(current)<ElementCovert(pre)){
    		negative=-1;
    	}
    	return negative;
    }
    
    public static int ElementCovert(char intput){
    	int result=0;
    	if(intput=='I'){
    		result=1;
    	}else if(intput=='V'){
    		result=5;
    	}else if(intput=='X'){
    		result=10;
    	}else if(intput=='L'){
    		result=50;
    	}else if(intput=='C'){
    		result=100;
    	}else if(intput=='D'){
    		result=500;
    	}else if(intput=='M'){
    		result=1000;
    	}
    	return result;
    }
    
    public int romanToIntwithmap(String s) {
        int result = 0;
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int prevNum = romanMap.get(s.charAt(s.length() - 1));
        result = prevNum;
        for (int i = s.length() - 2; i >= 0 ; i--) {
            int currNum = romanMap.get(s.charAt(i));
            if (currNum >= prevNum) result += currNum;
            else result -= currNum;
            prevNum = currNum;
        }

        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y=romanToInt("DCCCXC");
		System.out.println(y);
	}

}
