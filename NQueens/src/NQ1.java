import java.util.*;
public class NQ1 {

	public int totalNQueens(int n) {
        //write your code here
        if (n < 1) {
            return 0;
        }
        int result = 0;
        int[] path = new int[n];
        helper1(result, path, 0);
        return result;
    }
    
    private void helper1(int result, int[] path, int row){
        if (row == path.length) {
            result++;
            return;
        }
        
        for (int i = 0; i < path.length; i++) {
            if (isValid(path, row, i)) {
                path[row] = i;
                helper1(result, path, row + 1);
            }
        }
    }
    
    private boolean isValid(int[] path, int row, int col){
        for (int i = 0; i < row; i++) {
            if (col == path[i]) {
                return false;
            } else if (row + col == i + path[i]) {
                return false;
            } else if (row - col == i - path[i]) {
                return false;
            }
        }
        return true;
    }
    
 	public ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (n<1) {
            return result;
        }
        int[] path = new int[n];
        helper (result,path,0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<String>> result, int[] path, int row){
        if(row==path.length){
            //generate result
            result.add(dashboard(path));
            return;
        }
        
        for(int i=0;i<path.length;i++){
            if(isValidate(path,row,i)){
                path[row] = i;
                helper(result, path, row+1);
            }
        }
    }
    
    private boolean isValidate(int[] path, int row, int col){
        for(int i = 0; i<col; i++){
            if(col == path[i]){
                return false;
            }else if(row - col == i + path[i]) {
                return false;
            }else if(row - col == i - path[i]) {
                return false;
            }
        }
        return true;
    }
    
    private ArrayList<String> dashboard(int[] path){
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0;i<path.length;i++){
            String row = "";
            for(int j=0;j<path.length;j++){
                if(path[i]==j){
                    row+="Q";
                }else{
                    row+=".";
                }
            }
            result.add(row);
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQ1 test =new NQ1();
		ArrayList<ArrayList<String>> result =new ArrayList<ArrayList<String>>();
		result=test.solveNQueens(2);
		int resultint = test.totalNQueens(1);
		System.out.print(result);
		System.out.print(resultint);

	}

}
