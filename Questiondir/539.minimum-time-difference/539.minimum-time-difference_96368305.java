public class Solution {
    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> list=new ArrayList<>();
        for (String s: timePoints) list.add(gettime(s));
        Collections.sort(list);
        int diff=Integer.MAX_VALUE, len=list.size();
        for (int i=0;i<len;i++) {
            if (i!=len-1) diff=Math.min(diff, list.get(i+1)-list.get(i));
            else diff=Math.min(diff, list.get(0)+24*60-list.get(i));
        }
        return diff;

    }

    private int gettime(String time) {
        String[] s=time.split(":");
        return Integer.parseInt(s[0])*60+Integer.parseInt(s[1]);
    }
}