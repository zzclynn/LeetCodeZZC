import java.util.*;
public class FindMedian {
	public static int[] medianII(int[] nums) {
        // write your code here
        int[] result = new int[0];
        if( nums == null || nums.length == 0) {
            return result;
        }
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
        maxheap.offer(-Math.min(nums[0],nums[1]));
        minheap.offer(Math.max(nums[0],nums[1]));
        result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.min(nums[0],nums[1]);

        for(int i = 2; i < nums.length; i++) {
            int maxtop = -maxheap.peek();
            int mintop = minheap.peek();
            
            if(nums[i] < maxtop){
                if(maxheap.size() > minheap.size()) {
                    minheap.offer(-maxheap.poll());
                } 
                maxheap.offer(-nums[i]);
            } else if (nums[i] <= mintop && nums[i] >= maxtop) {
                if(minheap.size() > maxheap.size()) {
                    maxheap.offer(-nums[i]);
                } else {
                    minheap.offer(nums[i]);
                }
            } else {
                if(minheap.size() > maxheap.size()) {
                    maxheap.offer(-minheap.poll());
                }
                minheap.offer(nums[i]);
            }
            
            if (maxheap.size() >= minheap.size()){
                result[i] = - maxheap.peek();
            }  else {
                result[i] = minheap.peek();
            }
           
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{2,20,13,18,15,8,3,5,4,25};
		int[] result = medianII(input);
		System.out.print(result);
	}

}
