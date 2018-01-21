class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> ones = new ArrayList<>();
        List<Integer> cnts = new ArrayList<>();
        char last = '#';
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch != last) {
                if (last != '#') {
                    ones.add((last - '0'));
                    cnts.add(cnt);
                }

                last = ch;
                cnt = 1;
            } else {
                cnt ++;
            }
        }

        ones.add((last - '0'));
        cnts.add(cnt);


        int ans = 0;
        for (int i = 1; i < ones.size(); i++) {
            ans += Math.min(cnts.get(i - 1), cnts.get(i));
        }

        return ans;
    }
}