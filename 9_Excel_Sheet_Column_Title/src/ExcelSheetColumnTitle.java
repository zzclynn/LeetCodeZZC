
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
    	StringBuilder tempbuffer=new StringBuilder();
    	char temp;
    	
    	do
    	{	n=n-1;
    		temp=(char) (n%26+'A');
    		tempbuffer.insert(0,temp);
    	}while((n/=26)!=0);
    	
        return tempbuffer.toString();
    }
    public static String converToTitlenoStringBuilder(int n)
    {
    	//this method use same idea but no stringbuilder involved
        String s = "";
        while(n != 0){
            s = (char)('A'+ (n - 1) % 26) + s;
            n = (n-1) / 26;
        }
        return s;
    }
    
	public static void main(String[] args) {
		int[] num=new int[]{1,2,3,4,5,5,4,3,4,6};
		String y=converToTitlenoStringBuilder(27);
		System.out.println(y);
	}

}
