import java.util.*;
public class Permute {
	public static List<List<Integer>> permute(int[] num) {
	    ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
	     if(num.length == 0 ) return result;
	     else if (num.length == 1) {
	         ArrayList<Integer> inner = new ArrayList<Integer>();
	         inner.add(num[0]);
	         result.add(inner);
	         return result;
	     }

	     else{
	         int n = num.length-1;
	         int[] next= new int[n];
	         int left = num[n];
	         System.arraycopy(num,0, next, 0, n);
	         for(int i:next){
	             System.out.print(i + " ");
	         }
	        List<List<Integer>> tmp = permute(next);
	         for (List<Integer> list : tmp)
	         {
	             int length = list.size();
	             for(int i=0;i<=length;i++){
	                 ArrayList<Integer> tmplist = new ArrayList<Integer>();
	                 tmplist = new ArrayList<Integer>(list);
	                 tmplist.add(i,left);
	                 result.add(tmplist);
	             }

	         }

	         return result; 
	     }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test=new int[]{1,2,3};
		List<List<Integer>> result=permute(test);
		System.out.println(result);
		System.out.println("###################");
	}

}
