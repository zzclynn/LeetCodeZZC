
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
    	if(s.length()==0){return false;}
    	int start=0;
    	int end=s.length()-1;
    	while(true){
    		if(start==end||start-end==1){return true;}
    		if(!inboundary(s.charAt(start))||!inboundary(s.charAt(end))){
    			if(!inboundary(s.charAt(start))&&!inboundary(s.charAt(end))){
    				start++;
    				end--;  				
    			}
    			else if(!inboundary(s.charAt(start))&&inboundary(s.charAt(end))){
    				start++;
    			}
    			else if(inboundary(s.charAt(start))&&!inboundary(s.charAt(end))){
    				end--;
    			}
    			continue;
    		}
    		if(start==end||start-end==1){break;}
    		if(getalphnumber(s.charAt(start))!=getalphnumber(s.charAt(end))){
    			break;
    		}
			start++;
			end--;  			    		    		
    	}
        return false;
    }
    public static boolean inboundary(char x){
    	if(x-'A'<0 || (x-'A'>25 && x-'a'<0)|| x-'a'>25){
    		return false;
    	}
    	else{
    		return true;
    	}
    }
    public static int getalphnumber(char x){
    	if(x-'a'>=0 && x-'a'<26){
			return x-'a';
		}
		else if(x-'A'>=0 && x-'A'<26){
			return x-'A';
		}
		else{
			return -1;
		}
    }
    public static boolean isPalindromebest(String s) {
        s = s.toLowerCase();
        int lo = 0, hi = s.length()-1;
        while(lo < hi) {
            while(!Character.isLetterOrDigit(s.charAt(lo)) && lo < hi) lo++;
            while(!Character.isLetterOrDigit(s.charAt(hi)) && lo < hi) hi--;
            if(s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        return true;
    }
    
    public static boolean isPalindromeJAVAOnly(String s) {
        String ss = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        return ss.equals(new StringBuilder(ss).reverse().toString());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strs="         ";
		boolean Pascal=isPalindrome(strs);
		System.out.println(Pascal);	}

}
