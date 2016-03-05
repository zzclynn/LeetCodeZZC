import java.util.*;
public class Triangle {
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        if(triangle==null){
            return 0;
        }
        int n = triangle.size();

        int[][] state= new int[n][n];
        ArrayList<Integer> temp = triangle.get(0);
        state[0][0]=temp.get(0);
        
        for(int i=1;i<n;i++){
            temp = triangle.get(i);
            for(int j=0;j<=i;j++){
                if(j==0){
                    state[i][j]=state[i-1][j]+temp.get(j);
                }else if(j==i){
                    state[i][j]=state[i-1][j-1]+temp.get(j);
                }else{
                    state[i][j]=Math.min(state[i-1][j],state[i-1][j-1])+temp.get(j);
                }
            }
        }
        
        int result=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            result=Math.min(result,state[n-1][i]);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> input = new ArrayList<> ();
		ArrayList<Integer> inputs= new ArrayList<Integer> ();
		inputs.add(1);
		input.add(inputs);
		inputs= new ArrayList<Integer> ();
		inputs.add(2);
		inputs.add(3);
		input.add(inputs);
		inputs= new ArrayList<Integer> ();
		inputs.add(2);
		inputs.add(3);
		inputs.add(1);
		input.add(inputs);
		int result = minimumTotal(input);
		System.out.println(result);
		
	}

}
