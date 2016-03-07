import java.util.*;

public class previouspermutation {
	public static ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		if(nums == null || nums.size() == 0) {
		    return nums;
		}
		int index = nums.size() - 2;
		while(index >=0) {
		    if(nums.get(index)>nums.get(index + 1)){
		        break;
		    }
		    index--;
		}
		
		if(index >= 0) {
		    int j = index + 1;
		    for(; j< nums.size();) {
		        if(nums.get(j) < nums.get(index)) {
		            j++;
		        }
		    }
		    int temp = nums.get(j - 1);
		    nums.set(j - 1,nums.get(index));
		    nums.set(index, temp);
		}
		reverse(nums, index + 1, nums.size()-1);
		return nums;
    }
    
    private static void reverse(ArrayList<Integer> nums, int start, int end){
        while(start<end) {
            int temp = nums.get(start);
            nums.set(start,nums.get(end));
            nums.set(end, temp);
            start++;
            end --;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(2);
		input.add(1);
		input.add(3);
		ArrayList<Integer> result = previousPermuation(input);
		System.out.print(result);
	}

}
