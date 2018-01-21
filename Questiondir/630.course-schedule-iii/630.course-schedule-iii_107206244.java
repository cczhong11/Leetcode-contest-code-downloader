	public class Solution {
	    public int scheduleCourse(int[][] courses) {
	        Arrays.sort(courses, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return a[1] - b[1];
				}
			});
	        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	        int n = courses.length;
	        int s = 0;
	        for(int i = 0;i < n;i++){
	        	int[] c = courses[i];
	        	s += c[0];
	        	pq.add(-c[0]);
	        	while(s > c[1]){
	        		s += pq.poll();
	        	}
	        }
	        return pq.size();
	    }
	}	
