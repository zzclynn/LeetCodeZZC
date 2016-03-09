import java.util.*;
public class Permutation2 {

 public static List<List<Integer>> permuteUnique1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> each = new ArrayList<>();
        each.add(nums[0]);
        res.add(each);
	    if (nums.length == 1) {return res;}
	    for (int i = 1; i < nums.length; i++) {
	        List<List<Integer>> temp = new ArrayList<>();
	        for (List<Integer> item: res) {
	            for (int j = 0; j <= item.size(); j++) {
	                List<Integer> per = new ArrayList<>();
	                per.addAll(item);
	                per.add(j, nums[i]);
	                if(!temp.contains(per)) temp.add(per);
	                
                }
            }
            res=temp;
        }
        return res;
    }
 
	 public static ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
	     // write your code here
	     ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	     if(nums==null || nums.size()==0){
	         return result;
	     }
	     ArrayList<Integer> item = new ArrayList<Integer>();
	     Collections.sort(nums);
	     int size = nums.size();
	     permuteUniquehelper(result,item,nums,size);
	     return result;
	 }
	 
	 private static void permuteUniquehelper(ArrayList<ArrayList<Integer>> result,
	                                 ArrayList<Integer> item,
	                                 ArrayList<Integer> nums,
	                                 int size){
	     if(item.size()==size){
	         if(!result.contains(item)){
	             result.add(new ArrayList<Integer>(item));
	         }
	         return;
	     }
	     for(int i=0; i<nums.size();i++){
	
	         item.add(nums.get(i));
	         nums.remove(i);
	         permuteUniquehelper(result,item,nums,size);
	         nums.add(i, item.get(item.size()-1));
	         item.remove(item.size()-1);
	     }
	 }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test=new int[]{3,3,0,0,2,3,2};
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		ArrayList<ArrayList<Integer>> result=permuteUnique(input);
		System.out.println(result);
		System.out.println("###################");
}

}
