import java.util.Stack;
public class LongestPalindromicSubstring {
    public static String longestPalindromeTimeLimitedExceedSolution(String s) {
        if(s==null) return null;
        if(s.length()==1) return s;
        Stack st = new Stack();
        st.push(s.charAt(0));
        int longestnumber=0;
        Character centertemp=s.charAt(0);
        int centerlocation=0;
        for(int i=1; i<s.length();i++){
            if(s.charAt(i)==(Character)st.peek()||s.charAt(i)==centertemp){
                Stack temp= (Stack)st.clone();
         
                int tempnumber=0;
                if(s.charAt(i)==centertemp&&i!=1) {
                    tempnumber=1;
                    temp.pop();
                }
                int j=i;
                while(!temp.empty() && j<s.length()){
                    if(s.charAt(j)!=(Character)temp.peek()) break;
                    temp.pop();
                    tempnumber+=2;
                    if(tempnumber>longestnumber){
                        longestnumber=Math.max(tempnumber,longestnumber);
                        centerlocation=i;
                        if(s.charAt(i)==centertemp&&i!=1) {
                            centerlocation=i-1;
                        }
                    }
                    j++;
                }
            }
            st.push(s.charAt(i));
            centertemp=s.charAt(i-1);
        }
        char[] input = s.toCharArray();
        char[] output= new char[longestnumber];
        System.arraycopy(input, centerlocation-longestnumber/2, output, 0, longestnumber);
        return String.valueOf(output);
    }
    
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        while (len >= 0) {
            for (int i = 0; i + len - 1 < chars.length; i++) {
                int left = i;
                int right = i + len - 1;
                boolean good = true;
                while (left < right) {
                    if (chars[left] != chars[right]) {
                        good = false;
                        break;
                    }
                    left++;
                    right--;
                }
                if (good)
                    return s.substring(i, i + len);
            }
            --len;
        }

        return "";
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x=longestPalindromeTimeLimitedExceedSolution("ccc");
		System.out.println(x);
	}

}
