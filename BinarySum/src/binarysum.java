import java.util.*;
 
public class binarysum {
	public static class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	public static List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<Integer>();
        helper(result, path, root, target);
        return result;
    }
    
    private static void helper(List<List<Integer>> result, List<Integer> path
                        ,TreeNode root, int target){
        if(target == 0) {
            result.add(new ArrayList(path));
        }
        if(root == null || root.val > target || target < 0){
            return;
        }
        
        path.add(root.val);
        if(root.left != null && target -root.left.val == 0){
        	path.add(root.left.val);
        	result.add(new ArrayList(path));
        	path.remove(path.size() - 1);
        	return;
        }
        if(root.right != null && target -root.right.val == 0){
        	path.add(root.right.val);
        	result.add(new ArrayList(path));
        	path.remove(path.size() - 1);
        	return;
        }
        helper(result,path,root.left,target - root.val);
        helper(result,path,root.right, target - root.val);
        path.remove(path.size()-1);

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode newtree = new TreeNode(1);
		newtree.left = new TreeNode(2);
		newtree.right = new TreeNode(4);
		newtree.left.left = new TreeNode(2);
		newtree.left.right = new TreeNode(3);
		//List<List<Integer>> result = binaryTreePathSum(newtree, 5);
		//System.out.println(result);
		Stack<ArrayList<Integer>> test = new Stack<ArrayList<Integer>>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		test.push(new ArrayList (array));
		array.add(3);
		test.push(new ArrayList (array));	
		System.out.println(test.pop());
		System.out.println(test.pop());
	}

}
