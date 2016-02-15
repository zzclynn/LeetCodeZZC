import java.util.*;
public class iprestore {
	public static ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        if(s == null || s.length()==0) {
            return result;
        }
        
        helper(result, s,"", 4);
        return result;
        
    }
    
	private static void helper(ArrayList<String> result, String s, String path, int dotleft){
        if(dotleft == 0) {
            if(s == "") {
                result.add(path.substring(0,path.length()-1));
            }
            return;
        }
        int tempnumber = 0;
        String temppath = "";
        for (int i = 0; i < 3 && i < s.length(); i++){
            if(s == "" && dotleft != 0) {
                return;
            }
            Character tempchar = s.charAt(s.length() - 1 - i);
            if(tempchar == '0' && i > 0) {
                continue;
            }
            tempnumber = tempnumber  + (int)( tempchar - '0') * (int)Math.pow(10, i);
            if(tempnumber == 255) {
            	tempnumber = 255;
            }
            temppath = s.substring(s.length() - 1 - i, s.length()) + ".";
            if(tempnumber <= 255) {
                if (s.length() - i - 1 <= 0) {
                    helper (result, "", temppath + path, dotleft - 1);
                } else {
                    helper (result, s.substring(0, s.length() - 1 - i), temppath + path, dotleft - 1);
                }
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				ArrayList<String> result = restoreIpAddresses("25525511135");
				System.out.println(result);
	}

}
