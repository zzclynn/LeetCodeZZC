import java.util.*;
public class wordladder {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();
        
        BFS(start, end, dict, map);
        
        path.add(start);
        DFS(start, end, dict, map, result, path);
        return result;
    }
    
    private void BFS(String start, String end, Set<String> dict, HashMap<String, Integer> map){
        ArrayList<String> queue = new ArrayList<String>();
        queue.add(start);
        map.put(start, 1);
        
        int mindepth = Integer.MIN_VALUE;
        int startindex = 0;
        while (startindex<queue.size()) {
            String crt = queue.get(startindex++);
            int crtdepth = map.get(crt);
            if ( crtdepth >= mindepth){
                continue;
            }
            if (crt.equals(end)) {
                mindepth = Math.min(crtdepth,mindepth);
                continue;
            }
            for(int i = 0; i < crt.length(); i++){
                char[] crtchar = crt.toCharArray();
                for(char j = 'a'; j <= 'z'; j++){
                    crtchar[i] = j;
                    String newcrt = new String(crtchar);
                    if (dict.contains(newcrt) && !map.containsKey(newcrt)) {
                        queue.add(newcrt);
                        map.put(newcrt, crtdepth + 1);
                    }
                }
            }
        }
    }
    
    private void DFS(String start, String end, Set<String> dict, HashMap<String, Integer> map, 
                    ArrayList<ArrayList<String>> result, ArrayList<String> path){
        if(start.equals(end)){
            result.add(new ArrayList<String>(path));
            return;
        }
        
        for(int i = 0; i < start.length(); i++){
            char[] crtchar = start.toCharArray();
            for (char j = 'a'; j<='z'; j++){
                crtchar[i] = j;
                String newcrt = new String(crtchar);
                if(map.containsKey(newcrt) && map.get(newcrt)== map.get(start) +1){
                    path.add(newcrt);
                    DFS(newcrt, end, dict, map, result, path);
                    path.remove(path.size()-1);
                }
            }
        }
    }
	public ArrayList<ArrayList<String>> findLadders1(String start, String end, Set<String> dict) {
        // write your code here  
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (start == null || end == null || dict == null) {
            return result;
        }
        ArrayList<String> path = new ArrayList<String>();
        if (dict.contains(start)) {
            dict.remove(start); 
        }
        path.add(start);
        helper (result, path, start, end, dict, -1);
        return result;
    }
    
    private void helper (ArrayList<ArrayList<String>> result,
                        ArrayList<String> path, String start,
                        String end, Set<String> dict, int noposition) {
        if (start.equals(end)) {            	
        	result.add(new ArrayList<String>(path));
        	return;
        }
            
        
        
        for(int i = 0; i<start.length(); i++) {
        	if (i == noposition) {
        		continue;
        	}
            char[] chars = start.toCharArray();
            for(int letter = 0; letter<26; letter++){
                if (chars[i] !=  (char) ('a' + letter)) {
                    chars[i] =  (char) ('a' + letter);
                    String newstart = String.valueOf(chars);
                    if(dict.contains(newstart)) {
                        dict.remove(newstart);
                        path.add(newstart);
                        helper(result, path, newstart, end, dict, i);
                        dict.add(newstart);
                        path.remove(path.size()-1);
                    }
                }
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // write your code here
		wordladder test = new wordladder();
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("cog");
        dict.add("dog");
        dict.add("tot");
        dict.add("hog");
        dict.add("hop");
        dict.add("pot");
        dict.add("dot");
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		result = test.findLadders("hot", "dog", dict);
		System.out.print(result);
	}

}
