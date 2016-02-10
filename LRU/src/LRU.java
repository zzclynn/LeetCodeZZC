import java.util.*;

public class LRU {
    class ListNodenew{
        ListNodenew next;
        int Val;
        int Key;
        public ListNodenew(int key, int val){
            this.Val = val;
            this.Key = key;
            this.next = null;
        }
    }
    
    ListNodenew dummy;
    ListNodenew tail;
    ListNodenew prev;
    HashMap<Integer, ListNodenew> stack;
    int stackcapacity;
    // @param capacity, an integer
    public LRU(int capacity) {
        // write your code here
        this.dummy = new ListNodenew(-1,-1);
        this.tail = dummy;
        this.prev = dummy;
        this.stack = new HashMap<Integer, ListNodenew>();
        this.stackcapacity = capacity;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if(stack.containsKey(key)){
            ListNodenew getresult = stack.get(key);
            int result = getresult.next.Val;
            movetotail(getresult);
            return result;
        }
        return -1;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if(stack.containsKey(key)){
            ListNodenew node = stack.get(key);
            node.next.Val = value;
            movetotail(node);
        }else{
            if(stack.size()== stackcapacity){
                ListNodenew tempnode = dummy.next;
                dummy.next = tempnode.next;
                stack.remove(tempnode.Key);
                int updatekey = dummy.next.Key;
                stack.remove(updatekey);
                stack.put(updatekey, dummy);
            }
            ListNodenew newnode = new ListNodenew(key,value);
            ListNodenew prenode = tail;
            tail.next = newnode;
            tail = newnode;
            stack.put(key,prenode);
        }
    }
    
    private void movetotail(ListNodenew Node){
    	if(Node.next == tail){
    		return;
    	}
        ListNodenew pre = Node;
        ListNodenew curr = pre.next;
        pre.next = curr.next;  
    	int key = curr.next.Key;
    	stack.remove(key);
    	stack.put(key,pre);
        curr.next = null;
        tail.next = curr;
        key = curr.Key;
    	stack.remove(key);
    	stack.put(key,tail);
        tail = curr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRU test = new LRU(1);
		test.set(2, 1);
		int result = test.get(2);
		System.out.println(result);
		test.set(3, 2);
		result = test.get(2);
		System.out.println(result);
		result = test.get(3);
		System.out.println(result);
		result = test.get(2);
		System.out.println(result);
		result = test.get(1);
		System.out.println(result);
		
		
		test.set(1, 1);
		test.set(2, 2);
		test.set(3, 3);
		test.set(4, 4);
		result = test.get(4);
		System.out.println(result);
		result = test.get(3);
		System.out.println(result);
		result = test.get(2);
		System.out.println(result);
		result = test.get(1);
		System.out.println(result);
		test.set(5, 5);
		result = test.get(1);
		System.out.println(result);
		result = test.get(2);
		System.out.println(result);
		result = test.get(3);
		System.out.println(result);
		result = test.get(4);
		System.out.println(result);
		result = test.get(5);
		System.out.println(result);
	}

}
