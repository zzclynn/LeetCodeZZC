import java.util.List;


public  class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String output="";
    	if(strs.length==0){return output;}
        String Shorteststr=null;
        int Shortest=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()==0){return output;}
        	if(strs[i].length()<Shortest){
        		Shorteststr=strs[i];
        		Shortest=strs[i].length();
        	}
        }
        int end=Shorteststr.length()-1;
        boolean resultflag;
        while(end>=0){
        	resultflag=true;
        	for(int i=0;i<strs.length;i++){

        		for(int j=0;j<=end;j++){   			
        			if(strs[i].charAt(j)!=Shorteststr.charAt(j)){
        				resultflag=false;
        				break;
        			}
        		}
        		if(!resultflag) break;
        	}	
        	if(resultflag){
    			for(int k=0;k<=end;k++){
    				output+=Shorteststr.charAt(k);
    			}
    			return output;
    		}
    		end--;
        }
        return output;
    }
    public String longestCommonPrefixSameLogicMoreNeat(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String prefix = "", minSt = strs[0];
        for (String st: strs)
            if (st.length() < minSt.length()) 
                minSt = st;
        for (int i=0; i<minSt.length(); i++) {
            for (String st: strs)
                if (st.charAt(i) != minSt.charAt(i))
                    return prefix;
            prefix += minSt.charAt(i);
        }
        return prefix;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs=new String[]{"aaa","aa","aaa"};
		String Pascal=longestCommonPrefix(strs);
		System.out.println(Pascal);
	}

}
