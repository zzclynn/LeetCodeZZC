
// This method is O(logN) 
// every 5 can generate 0, so n/5
// meanwhile ever 5*5 can generate a extra 0, so need to consider n/5/5
// try to keep recursion to find the maximum possible powers of 5 that smaller than n.
public class trailingZeroes {
	public static int trailingZeroes(int n) {
	    return (n < 5  ? 0 : (n/5 + trailingZeroes(n/5)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y=trailingZeroes(15);
		System.out.println(y);
	}
}
