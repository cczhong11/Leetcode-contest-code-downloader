public class Solution {
	private static class Element implements Comparable<Element> {
		public int time;
		public int endTime;
		public Element(int time , int endTime) {
			this.time = time;
			this.endTime = endTime;
		}
		public int compareTo(Element e) {
			if (this.endTime < e.endTime) {
				return - 1;
			} else if (this.endTime > e.endTime) {
				return 1;
			} else {
				return 0;
			}
		}
	}

    public int scheduleCourse(int[][] courses) {
     
    	int i , j , n = courses.length;
    	if (n == 0) {
    		return 0;
    	} else {
    		List<Element> list = new ArrayList<>();
    		for (i = 0;i < n;i ++) {
    			int time = courses[i][0];
    			int endTime = courses[i][1];
    			list.add(new Element(time , endTime));
    		}
    		Collections.sort(list);
    		int sum = 0 , ans = 0;
    		PriorityQueue<Integer> queue = new PriorityQueue<>(16 , (v1 , v2) -> {
    			if (v1 > v2) {
    				return - 1;
    			} else if (v1 < v2) {
    				return 1;
    			} else {
    				return 0;
    			}
    		});
    		for (Element e : list) {
    			if (sum + e.time <= e.endTime) {
    				queue.add(e.time);
    				sum += e.time;
    			} else {
    				if (e.time < queue.peek()) {
    					while (!queue.isEmpty() && sum + e.time > e.endTime) {
    						sum -= queue.poll();
    					}
    					sum += e.time;
    					queue.add(e.time);
    				}
    			}
    			if (queue.size() > ans) {
    				ans = queue.size();
    			}
    		}
    		return ans;
    	}
    	
    }
}