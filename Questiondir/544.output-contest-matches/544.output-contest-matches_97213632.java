public class Solution {
    public String findContestMatch(int n) {
        List<String> str = new ArrayList<>();
        for (int i = 1, j = n; i < j; i++, j--) {
            str.add("(" + i + "," + j + ")");
        }
        return reduce(str);
    }
    String reduce(List<String> str) {
        while (str.size() > 1) {
            List<String> newStr = new ArrayList<>();
            for (int i = 0, j = str.size() - 1; i < j; i++, j--) {
                newStr.add("(" + str.get(i) + "," + str.get(j) + ")");
            }
            str = newStr;
        }
        return str.get(0);
    }
}
