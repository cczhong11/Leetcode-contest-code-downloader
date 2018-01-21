import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        Set<Integer> diffPos = new TreeSet<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < positions.length; ++i) {
        	diffPos.add(positions[i][0]);
        	diffPos.add(positions[i][0] + positions[i][1] - 1);
        }
        int index = 0;
        for (int x : diffPos) {
        	map.put(x, index);
        	++index;
        }
        
        int N = diffPos.size();
        int[] height = new int[N]; 
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < positions.length; ++i) {
        	int l = positions[i][0];
        	int r = positions[i][0] + positions[i][1] - 1;
        	l = map.get(l);
        	r = map.get(r);
        	int maxH = 0;
        	for (int j = 0; j < height.length; ++j) {
        		if (j >= l && j <= r) {
        			maxH = Math.max(maxH, height[j]);
        		}
        	}
        	maxH += positions[i][1];
        	int val = 0;
        	for (int j = 0; j < height.length; ++j) {
        		if (j >= l && j <= r) {
        			height[j] = maxH;
        		}
        		val = Math.max(val, height[j]);
        	}
        	list.add(val);
        }
        return list;
    }
}