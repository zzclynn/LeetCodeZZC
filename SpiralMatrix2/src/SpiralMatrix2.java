import java.util.List;


public class SpiralMatrix2 {
	public static int[][] generateMatrix(int n) {
        if(n==0) return null;
        int col=n;
        int row=n;
        int[][] result= new int[n][n];
        int i=0; 
        int j=-1;
        int intnumber=1;
        while(true){
            for(int index=0; index<col;index++){
                result[i][++j]=intnumber++;
            }
            if(--row==0) break;
            for(int index=0; index<row;index++){
                result[++i][j]=intnumber++;
            }
            if(--col==0) break;
            for(int index=0; index<col;index++){
                result[i][--j]=intnumber++;
            }
            if(--row==0) break;
            for(int index=0; index<row;index++){
                result[--i][j]=intnumber++;
            }
            if(--col==0) break;
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test=3;
		int[][] result=generateMatrix(test);
		System.out.println(result);
		System.out.println("###################");

	}

}
