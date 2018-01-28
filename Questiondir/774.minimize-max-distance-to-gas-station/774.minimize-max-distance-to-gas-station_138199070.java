class Solution {
   public boolean isIdealPermutation(int[] A) {
        
    	return get1(A) == get2(A);
    	
    }
    
    private int get1(int[] A) {
    	
    	int i , n = A.length , ans = 0;
    	for (i = 0;i < n - 1;i ++) {
    		if (A[i] > A[i + 1]) {
    			ans ++;
    		}
    	}
    	return ans;
    	
    }
    
    private int query(int pos) {
    	
    	int ans = 0;
    	while (pos >= 1) {
    		ans += tree[pos];
    		pos -= (pos & (- pos));
    	}
    	return ans;
    	
    }
    
    private void update(int pos , int n , int value) {
    	
    	while (pos <= n) {
    		tree[pos] += value;
    		pos += (pos & (- pos));
    	}
    	
    }
    
    private int[] tree;
    
    private int get2(int[] A) {
    	
    	int i , n = A.length , ans = 0;
    	tree = new int[n + 1];
    	for (i = n - 1;i >= 0;i --) {
    		int value = A[i] + 1;
    		ans += query(value - 1);
    		update(value , n , 1);
    	}
    	return ans;
    	
    }
}