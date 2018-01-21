class Solution {
	void dfs(Map<Integer, List<Integer>> adj, int cur, Set<Integer> vst) {
		if (vst.contains(cur)) return;
		vst.add(cur);
		List<Integer> list = adj.get(cur);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				dfs(adj, list.get(i), vst);
				
			}
		}
		
	}

	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		
		Set<Integer> nodes = new HashSet<>();
		for (int i = 0; i < n; i++) {
			nodes.add(edges[i][0]);
			nodes.add(edges[i][1]);
		}
		
		for (int i = n - 1; i >= 0; i--) {
			Map<Integer, List<Integer>> adj = new HashMap<>();
			Set<Integer> vst = new HashSet<>();
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				int u = edges[j][0];
				int v = edges[j][1];
				if (adj.get(u) == null) {
					adj.put(u, new ArrayList<Integer>());
				}
				if (adj.get(v) == null) {
					adj.put(v, new ArrayList<Integer>());
				}
				adj.get(u).add(v);
				adj.get(v).add(u);
			}
			dfs(adj, edges[0][0], vst);
			boolean ok = true;
			for (int key : nodes) {
				if (!vst.contains(key)) {
					ok = false;
					break;
				}
			}
			if (ok) {
				return edges[i];
			}
		}
		return new int[]{};
	}
}