public class Solution {

	private int[] max1 , max2;
	private int[] min1 , min2;
	
    public int maxDistance(int[][] arrays) {
     
    	int i , n = arrays.length;
    	max1 = new int[n];
    	max2 = new int[n];
    	min1 = new int[n];
    	min2 = new int[n];
    	for (i = 0;i < n;i ++) {
    		int m = arrays[i].length;
    		if (i == 0) {
    			max1[i] = arrays[i][m - 1];
    			min1[i] = arrays[i][0];
    		} else {
    			max1[i] = Math.max(max1[i - 1] , arrays[i][m - 1]);
    			min1[i] = Math.min(min1[i - 1] , arrays[i][0]);
    		}
    	}
    	for (i = n - 1;i >= 0;i --) {
    		int m = arrays[i].length;
    		if (i == n - 1) {
    			min2[i] = arrays[i][0];
    			max2[i] = arrays[i][m - 1];
    		} else {
    			min2[i] = Math.min(min2[i + 1] , arrays[i][0]);
    			max2[i] = Math.max(max2[i + 1] , arrays[i][m - 1]);
    		}
    	}
    	int ans = - 1;
    	for (i = 0;i < n;i ++) {
    		int m = arrays[i].length;
    		int min = arrays[i][0] , max = arrays[i][m - 1];
    		if (i - 1 >= 0) {
    			int temp1 = min1[i - 1] , temp2 = max1[i - 1];
    			int temp = Math.abs(min - temp1);
    			if (temp > ans) {
    				ans = temp;
    			}
    			temp = Math.abs(min - temp2);
    			if (temp > ans) {
    				ans = temp;
    			}
    			temp = Math.abs(max - temp1);
    			if (temp > ans) {
    				ans = temp;
    			}
    			temp = Math.abs(max - temp2);
    			if (temp > ans) {
    				ans = temp;
    			}
    		}
    		if (i + 1 < n) {
    			int temp1 = min2[i + 1] , temp2 = max2[i + 1];
    			int temp = Math.abs(min - temp1);
    			if (temp > ans) {
    				ans = temp;
    			}
    			temp = Math.abs(min - temp2);
    			if (temp > ans) {
    				ans = temp;
    			}
    			temp = Math.abs(max - temp1);
    			if (temp > ans) {
    				ans = temp;
    			}
    			temp = Math.abs(max - temp2);
    			if (temp > ans) {
    				ans = temp;
    			}
    		}
    	}
    	
    	return ans;
    	
    }

}