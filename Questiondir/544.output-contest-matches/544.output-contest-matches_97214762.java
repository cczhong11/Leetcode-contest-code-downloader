public class Solution {
    private List<String> merge(List<String> arr) {
        int left = 0, right = arr.size() - 1;
        List<String> ret = new ArrayList<>();
        while (left < right) {
            String toAdd = "(" + arr.get(left++) + "," + arr.get(right--) + ")";
            ret.add(toAdd);
        }
        return ret;
    }
    public String findContestMatch(int n) {
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ret.add(Integer.toString(i));
        }
        while (ret.size() > 1) {
            ret = this.merge(ret);
        }
        return ret.get(0);
    }
}