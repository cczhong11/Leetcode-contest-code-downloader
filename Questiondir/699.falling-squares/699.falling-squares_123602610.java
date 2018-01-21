class Solution {
    	public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        LinkedList<int[]> list = new LinkedList<>();
        int p0start = positions[0][0];
        int p0end = positions[0][1] + p0start;
        res.add(positions[0][1]);
        list.add(new int[]{p0start, p0end, positions[0][1]});
        for (int i = 1; i < positions.length; i++) {
        	int start = positions[i][0];
        	int end = positions[i][0] + positions[i][1];
        	int height = positions[i][1];
        	int maxBottom = 0;
        	int insertionIdx = 0;
        	for (int j = 0; j < list.size();) {
        		int[] cur = list.get(j);
        		if (cur[1] <= start || cur[0] >= end) {
        			j++;
        			if (cur[1] <= start) {
        				insertionIdx++;
        			}
        			continue;
        		}
        		maxBottom = Math.max(maxBottom, cur[2]);
        		if (cur[1] > start && cur[1] <= end) {
        			if (cur[0] < start) {
        				cur[1] = start;
        				insertionIdx = j + 1;
        				j++;
        			} else {
        				list.remove(j);
        			}
        		} else {
        			if (cur[0] < start) {
        				list.add(j + 1, new int[]{end, cur[1], cur[2]});
        				cur[1] = start;
        				insertionIdx = j + 1;
        				j++;
        			} else {
        				cur[0] = end;
        				j++;
        			}
        		}
        	}
        	if (insertionIdx >= list.size()) {
        		list.add(new int[]{start, end, maxBottom+height});
        	} else {
        		list.add(insertionIdx, new int[]{start, end, maxBottom+height});	
        	}
        	
        	res.add(Math.max(res.get(i-1), maxBottom+height));
        }
        return res;
    }
}