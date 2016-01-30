import java.util.List;
import java.util.ArrayList;



public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
    	
        List<List<Integer>> Pascal =new ArrayList<List<Integer>>();
        if(numRows==0) return Pascal;
        List<Integer> thenumbers =new ArrayList<Integer>();
        thenumbers.add(1);
        
        Pascal.add(thenumbers);
        
        for(int i=1;i<numRows;i++){
            thenumbers =new ArrayList<Integer>();
            thenumbers.add(1);
            thenumbers.add(1);
            for(int j=1;j<i;j++){
            	thenumbers.add(j, (Pascal.get(i-1).get(j))+(Pascal.get(i-1).get(j-1)));
            }
        	Pascal.add(thenumbers);
        }
        
    	return Pascal;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> Pascal=generate(1);
		System.out.println(Pascal);
	}

}
