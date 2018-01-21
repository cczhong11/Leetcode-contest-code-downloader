import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int[] dx = new int[]{1, 0};
	static int[] dy = new int[]{0, 1};
	
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][][] maxC = new int[N][N][2 * N - 1];
        maxC[0][0][0] = grid[0][0];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
        	int[] cur = queue.poll();
        	int ax = cur[0];
        	int bx = cur[1];
        	int d = cur[2];
        	int ay = d - ax;
        	int by = d - bx;
        	for (int i = 0; i < 2; ++i) {
        		int aax = ax + dx[i];
        		int aay = ay + dy[i];
        		if (aax < 0 || aay < 0 || aax >= N || aay >= N || grid[aax][aay] == -1) {
        			continue;
        		}
        		for (int j = 0; j < 2; ++j) {
        			int bbx = bx + dx[j];
        			int bby = by + dy[j];
        			if (bbx < 0 || bby < 0 || bbx >= N || bby >= N || grid[bbx][bby] == -1) {
        				continue;
        			}
        			int extra = grid[aax][aay] + grid[bbx][bby];
        			if (extra == 2 && aax == bbx && aay == bby) {
        				--extra;
        			}
        			if (maxC[aax][bbx][d + 1] < maxC[ax][bx][d] + extra) {
        				maxC[aax][bbx][d + 1] = maxC[ax][bx][d] + extra;
        				queue.offer(new int[]{aax, bbx, d + 1});
        			}
        		}
        	}
        }
        return maxC[N - 1][N - 1][2 * N - 2];
    }
}