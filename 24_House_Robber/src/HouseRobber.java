
public class HouseRobber {
    public static int rob(int[] nums) {
        int odd=0;
        int even=0;
        for(int i=0;i<nums.length;i++){
        	if(i%2==0){
        		even=Math.max(even+nums[i], odd);
        	}
        	else{
        		odd=Math.max(odd+nums[i], even);
        	}
        }
        return Math.max(odd, even);
    }
    
    public int robbetterunderstand(int[] num) {
        int rob = 0; //max monney can get if rob current house
        int notrob = 0; //max money can get if not rob current house
        for(int i=0; i<num.length; i++) {
            int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array=new int[]{8,7,4,13,2,21,90,70,2};
		int sum=rob(array);
		System.out.println(sum);	
	}

}
