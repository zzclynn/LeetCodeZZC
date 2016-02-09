
public class CanJump {
    public static boolean canJump(int[] nums) {
        if(nums.length==0 ||nums.length==1 ) return true;
        int maximumlength= nums[0];
        if(maximumlength==0) return false;
        if(maximumlength>=nums.length-1) return true;
        for(int i=1;i<=maximumlength;i++){
            int[] dst = new int[nums.length-i];
            System.arraycopy(nums, i, dst, 0, nums.length-i); // Copies 2, 3, 4 into dst
            boolean result=canJump(dst);
            if(result) return true;
        }
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test=new int[]{3,2,1,0,4};
		boolean result=canJump(test);
		System.out.println(result);
		System.out.println("###################");
	}

}
