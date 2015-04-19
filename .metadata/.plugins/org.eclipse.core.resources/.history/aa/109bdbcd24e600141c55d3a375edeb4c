
public class ReverseBits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
    	char[] Bits = Integer.toBinaryString(n).toCharArray();
    	char[] theBits=new char[32];
    	for(int i=0;i<32;i++)
    	{
    		theBits[i]='0';
    	}
    	for(int i=0;i<Bits.length;i++)
    	{
    		theBits[32-Bits.length+i]=Bits[i];
    	}
    	char temp;
    	for(int i=0;i<16;i++)
    	{
    		temp=theBits[31-i];
    		theBits[31-i]=theBits[i];
    		theBits[i]=temp;
    	}
    	String bits="";
    	bits=String.copyValueOf(theBits);
    	int result=Integer.parseUnsignedInt(bits, 2);
        return result;
    }
    
    public static int BestSolutionreverseBit(int n) {
    	  int result = 0;
    	  for (int i = 0; i < 32; ++i) {
    	    result = result<<1  | (n & 1);
    	    n >>>= 1;
    	  }
    	return result;  
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result=reverseBits(1 );
		result=BestSolutionreverseBit(43261596 );
		System.out.println(result);
	}

}
