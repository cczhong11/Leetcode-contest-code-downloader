class Solution {
	int[] rank;
	int[] parent;
	
	int getParent(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			parent[x] = getParent(parent[x]);
			return parent[x];
		}
	}
	
	int merge(int x, int y) {
		int rx = getParent(x);
		int ry = getParent(y);
		if (rx == ry) return 0;
		if (rank[rx] < rank[ry]) {
			parent[rx] = ry;
		} else if (rank[rx] > rank[ry]) {
			parent[ry] = rx;
		} else {
			parent[rx] = ry;
			rank[ry]++;
		}
		return 1;
	}
	
	void init() {
        for (int i = 0; i < rank.length; ++i) {
        	rank[i] = 0;
        	parent[i] = i;
        }
	}
	
    public int[] findRedundantConnection(int[][] edges) {
        int maxNode = 0;
        for (int i = 0; i < edges.length; ++i) {
        	maxNode = Math.max(maxNode, edges[i][0]);
        	maxNode = Math.max(maxNode, edges[i][1]);
        }
        maxNode++;
        
        rank = new int[maxNode];
        parent = new int[maxNode];
        
        init();
        int setN = maxNode;
        for (int i = 0; i < edges.length; ++i) {
        	setN -= merge(edges[i][0], edges[i][1]);
        }
        
        for (int i = edges.length - 1; i >= 0; --i) {
        	init();
        	int nSetN = maxNode;
        	for (int j = 0; j < edges.length; ++j) {
        		if (i == j) continue;
        		nSetN -= merge(edges[j][0], edges[j][1]);
        	}
        	if (nSetN == setN) return edges[i];
        }
        return null;
    }
}