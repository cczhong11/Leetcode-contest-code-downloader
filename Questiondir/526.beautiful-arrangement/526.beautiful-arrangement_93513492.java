public class Solution {

	private int[] values = new int[20];
	private boolean[] vis = new boolean[20];
	private int ans = 0;
	
	public int countArrangement(int N) {
        
		ans = 0;
		Arrays.fill(vis ,false);
		dfs(1 , N);
		return ans;
		
    }
	
	private void dfs(int current , int N) {
		
		if (current == N + 1) {
			ans ++;
		} else {
			for (int i = 1;i <= N;i ++) {
				if (!vis[i] && check(i , current)) {
					values[current] = i;
					vis[i] = true;
					dfs(current + 1 , N);
					vis[i] = false;
				}
			}
		}
		
	}
	
	private boolean check(int value , int pos) {
		if ((value % pos == 0) || (pos % value == 0)) {
			return true;
		} else
			return false;
	}

}