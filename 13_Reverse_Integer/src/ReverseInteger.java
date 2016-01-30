
public class ReverseInteger {
    public static int reverse(int x) {
        long y=0;
        do{
            y*=10;
            y+=x%10;    
            if(y>Integer.MAX_VALUE||y<Integer.MIN_VALUE)
                return 0;
        }while((x/=10)!=0);
        return (int)y;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num=new int[]{1,2,3,4,5,5,4,3,4,6};
		int y=reverse(1053423647);
		System.out.println(y);
	}

}
