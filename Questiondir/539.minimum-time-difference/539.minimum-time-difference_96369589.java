public class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int min = 24*60+diff(timePoints.get(0), timePoints.get(timePoints.size()-1));
        
        for (int i=1; i<timePoints.size(); i++) {
            min = Math.min(min, diff(timePoints.get(i), timePoints.get(i-1)));
        }
        return min;
    }
    private int diff(String a, String b) {
        int hh = Integer.parseInt(a.substring(0,2))-Integer.parseInt(b.substring(0,2));
        int mm = Integer.parseInt(a.substring(3))-Integer.parseInt(b.substring(3));
        
        return 60*hh+mm;
    }
}