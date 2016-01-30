
public class HappyNumber {
    public static boolean isHappy(int n) {
    	boolean[] array = new boolean[162];
    	int testnumber=0;
    	
    	do{    		
    		testnumber=CalculateSquareSum(n);
    		if(testnumber==1)return true;
    		if(testnumber<162 && array[testnumber]==true) return false;
    		n=testnumber;
    		if(testnumber<162) array[testnumber]=true;
    	}while(true);   
    }
    
    public static int CalculateSquareSum(int n){
    	int result=0;
    	do{
    		result+=(int)Math.pow(n%10, 2);
    	}while((n/=10)!=0);
    	return result;
    }

	public static void main(String[] args) {
		int[] num=new int[]{1,2,3,4,5,5,4,3,4,6};
		boolean y=isHappy(99);
		System.out.println(y);
	}

}
