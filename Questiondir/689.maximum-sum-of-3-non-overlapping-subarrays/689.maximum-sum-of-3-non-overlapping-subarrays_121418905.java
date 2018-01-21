class Solution {
	int compare(int[] a, int[] b) {
		if (a[0] < b[0]) {
			return -1;
		} else if (a[0] == b[0]) {
			if (a[1] < b[1]) {
				return -1;
			} else if (a[1] == b[1]) {
				return a[2] - b[2];
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}
	
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int s = 0;
        int[] sum = new int[n];
       
        for (int i = 0; i < n; i++) {
        	if (i < k) {
        		s += nums[i];
        	} else {
        		s = s - nums[i - k] + nums[i];
        	}
        	if (i - k + 1 >= 0) {
        		sum[i - k + 1] = s;
        		//System.out.println("sum[" + (i - k + 1) + "] = " + sum[i - k + 1]);
        	}
        }
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        for (int i = 0; i + k <= n; i++) {
        	if (i == 0) {
        		left[i] = i;
        	} else {
        		if (sum[i] > sum[left[i - 1]]) {
        			left[i] = i;
        		} else {
        			left[i] = left[i - 1];
        		}
        	}
        }
        
        for (int i = n - k; i >= 0; i--) {
        	if (i == n - k) {
        		right[i] = i;
        	} else {
        		if (sum[i] >= sum[right[i + 1]]) {
        			right[i] = i;
        		} else {
        			right[i] = right[i + 1];
        		}
        	}
        }
        
        int ans = 0;
        int[] list = null;
        for (int i = k; i + k + k <= n; i++) {
        	int t = sum[left[i - k]] + sum[i] + sum[right[i + k]];
        	if (t > ans) {
        		ans = t;
        		list = new int[] {left[i - k], i, right[i + k]};
        	} else if (t == ans) {
        		int[] tempList = new int[] {left[i - k], i, right[i + k]};
        		if (compare(tempList, list) < 0) {
        			list = tempList;
        		}
        	}
        }
        return list;
    }
}