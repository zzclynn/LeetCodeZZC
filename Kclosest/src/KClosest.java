
public class KClosest {
	public static int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        if(A == null || A.length == 0) {
            return A;
        }
        
        int cross = crossOver(A, target);
        
        int count = 0;
        int left = cross-1;
        int right = cross+1;
        int[] output = new int[k];
        output[count++] = cross;
        
        while(count < k && left >= 0 && right < A.length) {
            if (target - A[left] > A[right] - target){
                output[count++] = A[right++];
            } else if (target - A[left] <= A[right] - target) {
                output[count++] = A[left--];
            } 
        }
        

        if(left < 0) {
            while (count < k && right < A.length){
                output[count++] = A[right++];
            }
        }
        if(right == A.length) {
            while (count < k && left >= 0){
                output[count++] = A[left--];
            }
        }
        
        return output;
        
    }
    
    private static int crossOver(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start+1 < end) {
            mid = start + (end - start)/2;
            if (nums[mid]<target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                return mid;
            }
        }
        
        if(Math.abs(nums[start]-target) < Math.abs(target - nums[end])){
            return start;
        }else {
            return end;
        }
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{1,2,3};
		int[] result = kClosestNumbers(A,2,3);
		System.out.print(result);
	}
}
