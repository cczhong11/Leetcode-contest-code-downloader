class Solution {
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        for (char c : time.toCharArray()) {
            if (c != ':') {
                set.add(c - '0');
            }
        }
        List<String> times = new ArrayList<>();
        generateTimes(set, times, "");
        Collections.sort(times);
        int cur = 0;
        for (int i = 0; i < times.size(); i++) {
            if (time.equals(times.get(i))) {
                cur = i;
                break;
            }
        }
        return cur == times.size() - 1 ? times.get(0) : times.get(cur + 1);
    }
    
    private void generateTimes(Set<Integer> set, List<String> times, String s) {
        if (s.length() == 5) {
            if (isValid(s)) {
                times.add(s);
            }
            return;
        }
        if (s.length() == 2) {
            s += ":";
        }
        for (int i : set) {
            generateTimes(set, times, s + i);
        }
    }
    
    private boolean isValid(String s) {
        if (Integer.parseInt(s.substring(0, 2)) >= 24 || Integer.parseInt(s.substring(3)) >= 60) {
            return false;
        } else {
            return true;
        }
    }
}