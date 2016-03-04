package reverseWord;

public class reverseWordinString {

	public static String reverseWords(String s) {
        // write your code
        if(s == null || s.length() == 0) {
            return s;
        }
        s = s.replaceAll("\\s+", " ");
        s += " ";
        char[] sArray = s.toCharArray();
        reverse(sArray, 0, sArray.length - 1);
        int start = 0;
        for(int i = 1; i < sArray.length; i++) {
            if(sArray[i] == ' '|| i == sArray.length - 1){
                reverse(sArray, start, i - 1);
                start = i;
            }
        }
        String result = new String(sArray);
        return result.trim();
    }
    
    private static void reverse(char[] sArray, int start, int end) {
        while(start < end) {
            char temp = sArray[start];
            sArray[start] =sArray[end];
            sArray[end] = temp;
            start++;
            end--;
        }
        return;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input= "world";
		String result = reverseWords(input);
		System.out.print(result);
	}

}
