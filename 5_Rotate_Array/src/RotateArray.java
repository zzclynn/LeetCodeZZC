import java.util.Arrays;
public class RotateArray {
    public static int[] rotate1(int[] nums, int k) {
        int length=nums.length;
        int step=k % length;
        int temp;

        int start=0;
        int end=length;
        while(start<end)
        {
        	temp=nums[end-1];
        	nums[end-1]=nums[start];
        	nums[start]=temp;
        	start++;
        	end--;
        }
        
        start=0;
        end=step;
        while(start<end)
        {
        	temp=nums[end-1];
        	nums[end-1]=nums[start];
        	nums[start]=temp;
        	start++;
        	end--;
        }
        
        start=step;
        end=length;
        while(start<end)
        {
        	temp=nums[end-1];
        	nums[end-1]=nums[start];
        	nums[start]=temp;
        	start++;
        	end--;
        }
        
        return nums;
    }
    public static int[] rotate2(int[] nums, int k) {
        int length=nums.length;
        int step=k % length;
    	int [] temp = new int[2*nums.length - step];
    	for(int i=0;i<length;i++)
    	{
    		temp[i]=nums[i];
    	}    	
    	for(int i=length;i<2*length-step;i++)
    	{
    		temp[i]=nums[i-length];
    	}
        System.arraycopy(temp, length-step, nums, 0, nums.length);
        return nums;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x=new int[]{1,2,3,4,5,6};
		int[] y=rotate2(x,4);
		System.out.println(Arrays.toString(y));
	}

}
