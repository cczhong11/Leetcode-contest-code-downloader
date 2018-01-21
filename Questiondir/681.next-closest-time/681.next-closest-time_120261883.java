class Solution {
   String res = "00:00";
    int diff = Integer.MAX_VALUE;

    public String nextClosestTime(String time) {
        int set = 0;
        for (int i = 0; i < time.length(); i++) {
            char ch = time.charAt(i);
            if (ch >= '0' && ch <= '9') {
                set |= 1 << (ch - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        solve(time, sb, 0, set);
        return res.substring(0,2) + ":" + res.substring(2);
    }

    private void solve(String time, StringBuilder sb, int index, int set) {
        if (index == 4) {
            int tmp = diffTime(time, sb.toString());
            if (tmp < this.diff) {
                res = sb.toString();
                diff = tmp;
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if ((set & ( 1 << i)) != 0) {
                sb.append(i);
                solve(time, sb, index+1, set);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private int diffTime(String time, String after) {
        String[] sp1 = time.split(":");

        int hour1 = Integer.parseInt(sp1[0]);
        int min1 = Integer.parseInt(sp1[1]);

        int hour2 = Integer.parseInt(after.substring(0, 2));
        int min2 = Integer.parseInt(after.substring(2));

        if (hour2 > 23 || min2 >= 60) return Integer.MAX_VALUE;

        if (hour2 < hour1 || (hour2 == hour1 && min2 <= min1)) {
            hour2 += 24;
        }
        return (hour2 - hour1) * 60 + min2 - min1;
    }
}