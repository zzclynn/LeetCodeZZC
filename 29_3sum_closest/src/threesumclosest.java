import java.util.Arrays;


public class threesumclosest {
    public static int threeSumClosest(int[] nums, int target) {
    	int result=nums[0] + nums[1] + nums[nums.length - 1];

    	Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            int low=i+1;
            int high=nums.length-1;
            while(low<high){
	            int sum = nums[i] + nums[low] + nums[high];

                if(sum==target) return sum;
                else if(sum>target) high--;
                else low++;
                result=Math.abs(result-target)<Math.abs(sum-target)?result:sum;

                System.out.println(result);

            }
            
        }
        return result;
    }
    public static int threeSumClosestaccepted(int[] num, int target) {
	    int result = num[0] + num[1] + num[num.length - 1];
	    Arrays.sort(num);
	    for (int i = 0; i < num.length - 2; i++) {
	        int start = i + 1, end = num.length - 1;
	        while (start < end) {
	            int sum = num[i] + num[start] + num[end];
	            if(sum==target) return sum;
	            else if (sum > target)end--;
	            else start++;
                result=Math.abs(result)<Math.abs(sum)?result:sum;
                System.out.println(result);
	        }
	    }
	    return result;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test=new int[]{0,1,2};
		int x=threeSumClosest(test,0);
		System.out.println(x);
		System.out.println("###################");

		x=threeSumClosestaccepted(test,0);
		System.out.println(x);
	}

}
