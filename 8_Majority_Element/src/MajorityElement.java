import java.util.*;
public class MajorityElement {
    public static int majorityElementbyHashTable(int[] num) {
        // Start with ten, expand by ten when limit reached
        Hashtable hash = new Hashtable(10,10);
        for (int i = 0; i < num.length; i++)
        {
        	addNum(hash,Integer.toString(num[i]));
        }
        Set<String> set = hash.keySet();
        Iterator<String> itr = set.iterator();
        String str = null,result = null;
        int maximum=0;
        while (itr.hasNext()) {
            str = itr.next();
            if(maximum<(int) hash.get(str)){
            	maximum=Math.max(maximum, (int) hash.get(str));
            	result=str;
            }           
          }
        return Integer.parseInt(result);
    }
    private static void addNum(Hashtable map, String num) {
        Object obj = map.get(num);
        if (obj == null) {
          map.put(num, 1);
        } else {
          int i = ((Integer) obj).intValue() + 1;
          map.put(num, new Integer(i));
        }
    }
    
    public static int majorityElementbySorting(int[] num) {
    	//this idea is smarter, since the the number of majority should be larger than n.length/2
    	//So we can sort this array in any order, and return the value at the position of n.length/2.
    	Arrays.sort(num);
    	return num[num.length/2];
    }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num=new int[]{1,2,3,4,5,5,4,3,4,6};
		int y=majorityElementbySorting(num);
		System.out.println(y);
	}	
}
