class Solution {
    public String nextClosestTime(String time) {
        Set<Character> set = new HashSet<>();
        for (char c : time.toCharArray()) {
            set.add(c);
        }
        String[] arr = time.split(":");
        int hour = Integer.valueOf(arr[0]), minute = Integer.valueOf(arr[1]);
        for (int i = 0; i < 60 * 24; i++) {
            minute += 1;
            hour = (hour + minute / 60) % 24;
            minute %= 60;
            String nh = (hour < 10? "0": "") + hour, nm = (minute < 10? "0": "") + minute;
            String nt = nh + ":" + nm;
            if (valid(nt, set))
                return nt;
        }
        return "00:00";
    }
    
    public boolean valid(String time, Set<Character> set) {
        for (char c : time.toCharArray()) {
            if (!set.contains(c)) return false;
        }
        return true;
    }
}