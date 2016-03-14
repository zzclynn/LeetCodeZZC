import java.util.*;
public class Permutation {
	public static List<List<Integer>> permute(int[] nums) {
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
	                temp.add(per);
	            }
	        }
	        res = temp;
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test=new int[]{3,2,1};
		List<List<Integer>> result=permute(test);
		System.out.println(result);
		System.out.println("###################");
	}
}
