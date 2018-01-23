public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ans = 60*24;
        List<Integer> mins = new ArrayList<Integer>();
        for(String s : timePoints) {
            String[] fd = s.split(":");
            int hh = Integer.valueOf(fd[0]);
            int mm = Integer.valueOf(fd[1]);
            mins.add(hh*60 + mm);
        }
        Collections.sort(mins);
        mins.add(mins.get(0)+60*24);
        for(int i = 0; i < mins.size()-1; i++) {
            int base = mins.get(i);
            int next = mins.get(i+1);
            //System.out.println(base + "," + next);
            ans = Math.min(next-base, ans);
        }
        return ans;
    }
}