
public class Number1bits {

    public static int hammingWeight(int n) {
    	int numofones=0;
    	int number=n;
    	while(number!=0){
    		if((number & 1)==1)
    		{
    			numofones++;
    		}
    		number>>>=1;
    	}
        return numofones;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result=hammingWeight(11);
		System.out.println(result);
	}
}
