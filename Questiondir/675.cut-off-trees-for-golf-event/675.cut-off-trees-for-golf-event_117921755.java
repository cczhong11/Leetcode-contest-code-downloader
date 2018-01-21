import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	static class TreePos {
		int r, c;
		int height;
		
		TreePos(int r, int c, int height) {
			this.r = r;
			this.c = c;
			this.height = height;
		}
	}
	int row, col;
	int[][] land;
	
	int minDist(int lastR, int lastC, int curR, int curC) {
		int[][] dist = new int[row][col];
		for (int[] d : dist) {
			Arrays.fill(d, -1);
		}
		
		int C = col;
		Queue<Integer> queue = new LinkedList<Integer>();
		dist[lastR][lastC] = 0;
		queue.offer(lastR * C + lastC);
		
		while (!queue.isEmpty()) {
			int val = queue.poll();
			int r = val / C;
			int c = val % C;
			if (r == curR && c == curC) return dist[curR][curC];
			for (int dr = -1; dr <= 1; ++dr) {
				for (int dc = -1; dc <= 1; ++dc) {
					if (dr == 0 ^ dc == 0) {
						int nr = r + dr;
						int nc = c + dc;
						if (nr < 0 || nr >= row || nc < 0 || nc >= col || dist[nr][nc] != -1 || land[nr][nc] == 0) {
							continue;
						}
						dist[nr][nc] = dist[r][c] + 1;
						queue.add(nr * C + nc);
					}
				}
			}
		}
		
		return -1;
	}
	
    public int cutOffTree(List<List<Integer>> forest) {
        row = forest.size();
        col = forest.get(0).size();
        land = new int[row][col];
        int treeCnt = 0;
        for (int r = 0; r < row; ++r) {
        	for (int c = 0; c < col; ++c) {
        		land[r][c] = forest.get(r).get(c);
        		if (land[r][c] > 1) {
        			++treeCnt;
        		}
        	}
        }
        TreePos[] allTree = new TreePos[treeCnt];
        treeCnt = 0;
        for (int r = 0; r < row; ++r) {
        	for (int c = 0; c < col; ++c) {
        		if (land[r][c] > 1) {
        			allTree[treeCnt] = new TreePos(r, c, land[r][c]);
        			++treeCnt;
        		}
        	}
        }
        Arrays.sort(allTree, new Comparator<TreePos>() {
        	public int compare(TreePos x, TreePos y) {
        		return x.height - y.height;
        	}
        });
        int pr = 0, pc = 0;
        int res = 0;
        for (int i = 0; i < treeCnt; ++i) {
        	int tmp = minDist(pr, pc, allTree[i].r, allTree[i].c);
        	if (tmp < 0) return -1;
        	res += tmp;
        	pr = allTree[i].r;
        	pc = allTree[i].c;
        }
        return res;
    }
}