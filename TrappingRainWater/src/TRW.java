
public class TRW {

    public static int trap(int[] height) {
        int n = height.length, l = 0, r = n - 1, water = 0, minHeight = 0;
        while (l < r) {
            while (l < r && height[l] <= minHeight)
                water += minHeight - height[l++];
            while (r > l && height[r] <= minHeight)
                water += minHeight - height[r--];
            minHeight = Math.min(height[l], height[r]);
        }
        return water;
    }
	
    public static int trap2(int[] A) {
        int vol = 0;
        if (A.length <= 2)  return vol;
        
        // go from left to right, find the left highest bar for each bar
        int[] lmh = new int[A.length];
        lmh[0] = 0;
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            lmh[i] = max;
            if (A[i] > max) max = A[i];
        }
        
        // go from right to left, find the right highest bar for each bar
        max = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            int left = lmh[i];
            int right = max;
            if (A[i] > max) max = A[i];
            // calculate the volume if there's a bowl shape
            int min = Math.min(left, right);
            if (min > A[i]) vol += min - A[i];
        }
        
        return vol;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[] test=new int[]{0,1,3,2,3,0};
				int result=trap2(test);
				System.out.println(result);
				System.out.println("###################");
	}

}
