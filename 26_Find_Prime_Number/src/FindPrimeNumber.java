
public class FindPrimeNumber {
    public static int countPrimes(int n) {
    	if(n<=2) return 0;
    	int sqrt=(int) Math.sqrt(n);
    	boolean[] isprime=new boolean[n];
    	for(int i=2;i<n;i++){
    		isprime[i]=true;
    	}
    	for(int i=2;i<=sqrt;i++){
    		if(isprime[i]){
    			for(int j=i*i;j<n;j+=i){
    				isprime[j]=false;
    			}
    		}
    	}
    	int count=0;
    	for(int i=2;i<n;i++){
    		count+=isprime[i]==true?1:0;
    	}
    	return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int x=countPrimes(5);
		 System.out.println(x);
	}

}
