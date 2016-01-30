
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String result = Integer.toString(x);
        if(result.charAt(0)=='-'){
        	return false;
        }
        int length=result.length();
        int forward=0;
        int backward=length-1;
        int i=0;
        while(i<length/2){
            if(result.charAt(forward)!=result.charAt(backward)){
                return false;
            }
            forward++;
            backward--;
            i++;
        }
        return true;
    }
    public static boolean isPalindromeBest(int x) {

        if (x < 0) return false;

        int p = x; 
        int q = 0; 

        while (p >= 10){
            q *=10; 
            q += p%10; 
            p /=10; 
        }

        return q == x / 10 && p == x % 10;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean y=isPalindrome(-1237321);
		System.out.println(y);
	}

}
