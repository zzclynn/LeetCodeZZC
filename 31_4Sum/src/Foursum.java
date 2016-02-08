import java.util.*;
public class Foursum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
    	Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length<4) return result;
        Hashtable<Integer,List<Integer>> table=new Hashtable<Integer,List<Integer>>();
        Hashtable<Integer,Integer> table1=new Hashtable<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
        	
        		table1.put(nums[i], i);

        }
        
        
        
        List<Integer> test=new ArrayList<>();
        test.add(0);
        for(int i=1;i<nums.length;i++){
        	if(nums[i]!=nums[i-1]){
        		table.put(nums[i-1], test);
        		test=new ArrayList<>();      		
        	}
        	test.add(i);  	
        }
        table.put(nums[nums.length-1], test);
        
      
        
        for(int i=0;i<nums.length-2;i++){
            int low=i+1;
            int high=nums.length-1;
            if(i==0 || i>0&& nums[i]!=nums[i-1]){
                while(low<high){
                	int temp=target-nums[i]-nums[low]-nums[high];
                    if(table.containsKey(temp)){
                    	List<Integer> fromtable=table.get(temp);
                    	for(int j=0;j<fromtable.size();j++){
                    		if(fromtable.get(j)>low &&fromtable.get(j)<high){      
                            	List<Integer> elements=new ArrayList();
                    			elements.add(nums[i]);
                                elements.add(nums[low]);
                                elements.add(nums[fromtable.get(j)]);
                                elements.add(nums[high]);
                                result.add(elements);
                                while(low<high && nums[low]==nums[low+1]) low++;
                                while(low<high && nums[high]==nums[high-1]) high--;                       
                                low++;
                                high--;
                                break;
                    		}
                    	}

                    }
                    else if (nums[low]+nums[high]+nums[i]>target-temp){
                        high--;
                    }
                    else{
                        low++;
                    }
                    
                }
            }
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 List<List<Integer>> result=new ArrayList<>();
		int[] test=new int[]{-2,-1,0,0,1,2};
 		result=fourSum(test,0);
		System.out.println(result);
		System.out.println("###################");
		
	}

}
