public class Solution {
	// <= value的
	private int lowerBound(List<Integer> list , int value) {
		
		int low = 0 , high = list.size();
		while (low < high) {
			int mid = (low + high) / 2;
			if (list.get(mid) > value) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		high --;
		if (high >= 0) {
			return high;
		} else {
			return - 1;
		}
		
	}

    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
     
    	List<Integer> ans = new ArrayList<>();
    	int pos1 = lowerBound(arr , x);
    	if (pos1 >= 0) {
    		int pos2 = pos1 + 1 , n = arr.size();
    		while (pos1 >= 0 && pos2 < n && k > 0) {
    			int value1 = arr.get(pos1);
    			int value2 = arr.get(pos2);
    			int diff1 = Math.abs(value1 - x);
    			int diff2 = Math.abs(value2 - x);
    			if (diff1 < diff2) {
    				ans.add(value1);
    				pos1 --;
    			} else if (diff1 > diff2) {
    				ans.add(value2);
    				pos2 ++;
    			} else {
    				ans.add(value1);
    				pos1 --;
    			}
    			k --;
    		}
    		while (pos1 >= 0 && k > 0) {
    			ans.add(arr.get(pos1));
    			pos1 --;
    			k --;
    		}
    		while (pos2 < n && k > 0) {
    			ans.add(arr.get(pos2));
    			pos2 ++;
    			k --;
    		}
    	} else {
    		// 如果没有小于等于的
    		for (int i = 0;i < k;i ++) {
    			ans.add(arr.get(i));
    		}
    	}
    	Collections.sort(ans);
    	return ans;
    	
    }
}