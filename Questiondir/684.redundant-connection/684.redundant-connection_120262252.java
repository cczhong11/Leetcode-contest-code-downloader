class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] p = new int[2001];
        Arrays.fill(p, -1);
        
        for (int[] arr : edges) {
			int root1 = find(p, arr[0]);
			int root2 = find(p, arr[1]);
			
			if (root1 == root2) {
				return arr;
			} else {
				//merge two root
				p[root1] = root2;
			}
		}
        
        return null;
    }
    
    // find root
	private int find(int[] p, int i) {
		if (p[i] == -1) {
			return i;
		} else {
			return find(p, p[i]);
		}
	}
}