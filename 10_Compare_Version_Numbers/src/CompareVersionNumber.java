
public class CompareVersionNumber {
    public static int compareVersion(String version1, String version2) {
    	int length=Math.max(version1.length(), version2.length());
        String[] ver1=generateStringArray(version1,length);
        String[] ver2=generateStringArray(version2,length);
        
        
        int verresult1=0,verresult2=0;
        int i=0;
        int result=0;
        while(i<length){
        	verresult1=stringtoint(ver1[i]);
        	verresult2=stringtoint(ver2[i]);
        	if(verresult1>verresult2){
        		result = 1;
        		break;
        	}else if(verresult1<verresult2){
        		result = -1;
        		break;
        	}   
        	i++;
        }
    	return result;
    
    }
    private static String[] generateStringArray(String str, int length)
    {
    	String[] ver=new String[length];
        int i=0;int j=0;
        while(i<str.length()){
        	ver[j]="";
            while(str.charAt(i)!='.'){
            	ver[j]=ver[j]+str.charAt(i);
            	if(i==str.length()-1){break;}
            	i++;
            }
            j++;
            i++;
        }
    	return ver;
    }
    private static int stringtoint(String str)
    {
    	if(str==null){return 0;}
    	int result=0;
    	int length=str.length();
    	for(int i=0;i<length;i++){
    		result=result*10+(int)(str.charAt(i)-'0');
    	}
    	return result;
    }
    
    public static int compareVersionwithallbuilding(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length = (v1.length >= v2.length ? v2.length : v1.length);
        for (int i = 0; i < length; i++) {
            if (Integer.valueOf(v1[i]) > Integer.valueOf(v2[i])) return 1;
            else if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[i])) return -1;
        }
        if (v1.length > v2.length && Integer.valueOf(v1[length]) > 0) return 1;
        else if (v1.length < v2.length && Integer.valueOf(v2[length]) > 0) return -1;
        else return 0;
    }
    
    public static int compareVersionRecursion(String v1, String v2) {
    	int v1L = 0,  v2L = 0, i = 0, j = 0;
	    while( i < v1.length() && v1.charAt(i) != '.')
	    {
            v1L = 10*v1L + (int)(v1.charAt(i++) - '0');     
	    }
	    while(j < v2.length() && v2.charAt(j) != '.')
	    {
            v2L = 10*v2L + (int)(v2.charAt(j++) - '0');     
	    }
	    if (v1L < v2L)
	        return -1;
	    else if (v1L > v2L)
	        return 1;
	    else // current level equals, compare next level
	    {
	        if (i+1 > v1.length() && j+1 > v2.length())
	            return 0;
	        else
	        {
	          String t1 = new String(v1.substring(Math.min(i+1,v1.length()),v1.length())); // min is to handle corner cases
	          String t2 = new String(v2.substring(Math.min(j+1,v2.length()),v2.length()));
	          return compareVersion(t1,t2);
	        }
	    }
	}
    
	public static void main(String[] args) {
		int[] num=new int[]{1,2,3,4,5,5,4,3,4,6};
		int y=compareVersionRecursion("1.0","1");
		System.out.println(y);
	}

}
