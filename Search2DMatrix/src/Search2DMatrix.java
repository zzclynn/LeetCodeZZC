import java.util.List;


public class Search2DMatrix {
	
	public static boolean searchMatrix(int[][] matrix, int target) {
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
	        return false;

	    int n = matrix.length, m = matrix[0].length;
	    int i = 0, j = m - 1;

	    while (i < n && j >= 0) {
	        int num = matrix[i][j];

	        if (num == target)
	            return true;
	        else if (num > target)
	            j--;
	        else
	            i++;
	    }

	    return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test= new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		boolean result=searchMatrix(test,19);
		System.out.println(result);
		System.out.println("###################");
	}

}
