	public class Solution {
	    public int findMinDifference(List<String> timePoints) {
	        int n = timePoints.size();
	        int[] s = new int[n];
	        for(int i = 0;i < n;i++){
	        	int h = Integer.parseInt(timePoints.get(i).substring(0, 2));
	        	int m = Integer.parseInt(timePoints.get(i).substring(3));
	        	s[i] = h*60+m;
	        }
	        Arrays.sort(s);
	        int min = 1440;
	        for(int i = 0;i < n;i++){
	        	int d = s[(i+1)%n]-s[i];
	        	if(d < 0)d += 1440;
	        	min = Math.min(min, d);
	        }
	        return min;
	    }
	}	
