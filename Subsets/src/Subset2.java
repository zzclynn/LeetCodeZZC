import java.util.*;
public class Subset2 {
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result= new ArrayList<>();
        if(S==null || S.size()==0){
            return result;
        }
        ArrayList<Integer> item= new ArrayList<Integer>();
        Collections.sort(S);
        subSetsHelper(result,item,S,0);
        return result;
    }
    
    private static void subSetsHelper(ArrayList<ArrayList<Integer>> result,
                                ArrayList<Integer> item,
                                ArrayList<Integer> S,
                                int position){
        result.add(new ArrayList<Integer>(item));
        for(int i=position; i<S.size();i++){
            if(i!=position && S.get(i)==S.get(i-1)){
                continue;
            }
            item.add(S.get(i));
            subSetsHelper(result,item,S,position+1);
            item.remove(item.size()-1);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> inputs= new ArrayList<Integer> ();
		inputs.add(1);
		inputs.add(2);
		ArrayList<ArrayList<Integer>> result = subsetsWithDup(inputs);
		System.out.println(result);
	}

}
