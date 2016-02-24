/**
 * Created by Zhicheng on 2/23/16.
 */
public class backpack {
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[] sizes = new boolean[m + 1];
        sizes[0] = true;

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            boolean[] past = new boolean[sizes.length];
            for(int j = 0; j < sizes.length; j++) {
                if(sizes[j]) {
                    past[j] = true;
                }
            }
            for(int j = 0; j < sizes.length; j++) {
                if(past[j] && A[i] + j <= m) {
                    sizes[j + A[i]] = true;
                    max = Math.max(j+A[i],max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = new int[]{3,4,8,5};
        int result = backPack(10,input);
        System.out.println(result);
    }}
