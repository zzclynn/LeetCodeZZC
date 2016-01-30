
public class atoi {
    public static int myAtoi(String str) {    	
        int i=0;
        int result=0;
        int neg=1;
        if(str.length()==0){
            return 0;
        }
        if(str.charAt(i)=='-'){
            neg=-1;
            i++;
        }else if(str.charAt(i)=='+'){
            i++;
        }
        while(i<str.length()){
            int x=(int)str.charAt(i)-'0';
            if(str.charAt(i)-'0'>9||str.charAt(i)-'0'<0){
            	break;
            }
            if(Integer.MAX_VALUE/10 < result || Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE %10 < str.charAt(i)-'0')
            	return neg == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            
            result=result*10+(int)(str.charAt(i)-'0');
            i++;
        }
        return result*neg;
        //*/
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y=myAtoi("+-2");
		System.out.println(y);
	}

}
