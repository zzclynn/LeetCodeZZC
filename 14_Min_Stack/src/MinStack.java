import java.util.ArrayList;
public class MinStack {
    private  ArrayList<Integer> minPosition;
    private  ArrayList<Integer> array;

    MinStack() {
        minPosition = new ArrayList<Integer>();
        array = new ArrayList<Integer>();
    }
    public void push(int x) {
        if (array.size() == 0) {
            minPosition.add(0);
        } else {
            int size = minPosition.size();
            if (x < array.get(minPosition.get(size - 1))) {
                minPosition.add(array.size());
            } else {
                minPosition.add(minPosition.get(size - 1));
            }
        }
        array.add(x);
    }

    public void pop() {
        array.remove(array.size()-1);
        minPosition.remove(minPosition.size()-1);
    }

    public int top() {
        return array.get(array.size()-1);
    }

    public int getMin() {
        return array.get(minPosition.get(minPosition.size()-1));
    }
/*
    public class MinStack {
        ArrayList<Integer> Storage;
        ArrayList<Integer> Min;
        
        public MinStack(){
            Storage= new ArrayList<Integer>();
            Min= new ArrayList<Integer>();
        }
        public void push(int x) {
            if(Storage.isEmpty()){
                Min.add(x);
            }
            else{
                if(x<Min.get(Min.size()-1)){
                    Min.add(x);
                }
                else{
                    Min.add(Min.get(Min.size()-1));
                }
                
            }
            Storage.add(x);
        }

        public void pop() {
            if(this.Storage.isEmpty()){
                return;
            }
            Storage.remove(Storage.size()-1);
            Min.remove(Min.size()-1);

        }

        public int top() {
            return Storage.get(Storage.size()-1);
        }

        public int getMin() {
            return Min.get(Min.size()-1);
        }
    }
    */
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num=new int[]{1,2,3,4,5,5,4,3,4,6};
		//int y=reverse(1053423647);
		//System.out.println(y);
	}

}
