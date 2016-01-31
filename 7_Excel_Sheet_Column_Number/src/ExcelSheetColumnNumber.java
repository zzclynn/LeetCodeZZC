
public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
    	int result=0;
    	int i=0;
    	while(i<s.length())
    	{
    		result+=s.charAt(i)-'A'+1;
    		i++;
    		if(i!=s.length()){
        		result=result*26;
    		}
    	}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y=titleToNumber("AA");
		System.out.println(y);
	}

}
