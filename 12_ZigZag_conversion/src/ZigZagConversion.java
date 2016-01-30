
public class ZigZagConversion {

    public static String convert(String s, int nRows) {
    	String[] temp=new String[nRows];
    	if(nRows==0){return null;}
    	for(int j=0;j<nRows;j++){
			temp[j]="";
		}
    	int i=0;
    	while(i<s.length())
    	{
    		for(int j=0;j<nRows;j++){
    			temp[j]=temp[j]+s.charAt(i);
    			i++;
    			if(i==s.length()){break;}
    		}
    		if(i==s.length()){break;}
    		for(int j=nRows-2;j>0;j--){
    			temp[j]=temp[j]+s.charAt(i);
    			i++;
    			if(i==s.length()){break;}
    		}	
    	}
    	String result="";
    	for(int j=0;j<nRows;j++){
    		result=result+temp[j];
		}
        return result;
    }
    public static String ConvertBetter(String s, int nRows){
        //Special case
        if (nRows >= s.length() || nRows == 1) {
            return s;
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < nRows; i++) {
            //Two gaps for the next character
            int gap1 = 2 * (nRows - 1 - i);
            int gap2 = 2 * i;

            int j = i;
            //Record the previous char position in original string
            int prevPos = 0;

            // Init buffer
            sb.append(s.charAt(j));

            while (j < s.length()) {
                prevPos = j;
                j += gap1;
                //gap1 is 0 when it is last row, do not add it twice
                if (j != prevPos && j < s.length()) {
                    sb.append(s.charAt(j));
                }
                prevPos = j;
                j += gap2;
                //gap2 is 0 when it is first row, do not add it twice
                if (j != prevPos && j < s.length()) {
                    sb.append(s.charAt(j));
                }
            }
        }

        return sb.toString();
    }
    public static String ConvertBestSoFar(String s, int nRows){
        //Analysis: the problem is convert a serial string to a Zig-Zag pattern
        //[0,1,2,3,4,5,6,7,8,9,...,N] with row m;
        //0                 2m-2                4m-4
        //1            2m-3 2m-1           4m-3
        //...      ...      ...      ...
        //m-2   m           3m-4  3m-2
        //m-1               3m-3
        //so the algorithm is basically an algebra converting of the indexes.
        //[s.length/(2m-2)]
        //[0,2m-2,4m-4,...,1,2m-3,2m-1]
    	
        //for each row in the Zig-Zag graph
        //for the first and last row:
        //[0,2m-2,4m-4,6m-6.....,]
        //[m-1,3m-3,5m-5]
        //for the middle rows
        //[i,2m-2-i,2m-2+i,4m-4-i,4m-4+i....]
        String result="";
        int i,j;
        int len=s.length();
        if (nRows==1) return s;
        for (i=0;i<nRows;i++){
            j=0;
            while (j<len+i){
                if (i<nRows-1 && i>0 && j>i){
                    result+=s.charAt(j-i);
                }
                if ((i+j)<len){
                    result+=s.charAt(j+i);
                }
                j+=2*nRows-2;
            }
        }
        return result;
    }
	public static void main(String[] args) {
		int[] num=new int[]{1,2,3,4,5,5,4,3,4,6};
		String y=convert("PAYPALISHIRING",3);
		System.out.println(y);
	}


}
