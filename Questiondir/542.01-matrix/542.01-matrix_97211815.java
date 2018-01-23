public class Solution {

	private static class Element {
		
		public int x , y , dist;
		public Element(int x , int y , int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
	}
	
	private int[][] dist;
	private boolean[][] vis;
	private int[] dx = new int[] {- 1 , 0 , 1 , 0};
	private int[] dy = new int[] {0 , 1 , 0 , - 1};
	
	public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
		
		int n = matrix.size();
		if (n > 0) {
			int m = matrix.get(0).size();
			if (m > 0) {
				dist = new int[n][m];
				vis = new boolean[n][m];
				Queue<Element> queue = new LinkedList<Element>();
				int i , j;
				for (i = 0;i < n;i ++) {
					for (j = 0;j < m;j ++) {
						if (matrix.get(i).get(j) == 0) {
							queue.add(new Element(i , j , 0));
							vis[i][j] = true;
						}
					}
				}
				while (!queue.isEmpty()) {
					Element e = queue.poll();
					dist[e.x][e.y] = e.dist;
					
					for (i = 0;i < 4;i ++) {
						int tx = e.x + dx[i];
						int ty = e.y + dy[i];
						if (tx >= 0 && tx < n && ty >= 0 && ty < m && !vis[tx][ty]) {
							vis[tx][ty] = true;
							queue.add(new Element(tx , ty , e.dist + 1));
						}
					}
				}
				
				List<List<Integer>> ans = new ArrayList<List<Integer>>();
				for (i = 0;i < n;i ++) {
					List<Integer> list = new ArrayList<Integer>();
					for (j = 0;j < m;j ++) {
						list.add(dist[i][j]);
					}
					ans.add(list);
				}
				return ans;
				
			} else {
				return Arrays.asList();
			}
		} else {
			return Arrays.asList();
		}
        
    }

}