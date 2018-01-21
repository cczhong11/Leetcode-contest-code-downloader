class Solution {
    public String nextClosestTime(String time) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < time.length(); ++i) {
            if (time.charAt(i) != ':') set.add(time.charAt(i));
        }
        System.out.println(set);
        int k = 0;
        do {
            time = next(time);
        } while (!isValid(time, set));
        return time;
    }
    
    private String next(String time) {
        String[] tokens = time.split(":");
        int hour = Integer.parseInt(tokens[0]);
        int minute = Integer.parseInt(tokens[1]);
        minute += 1;
        if (minute == 60) {
            minute = 0;
            hour += 1;
        }
        if (hour == 24) {
            hour = 0;
        }
        return String.format("%02d", hour) + ":" + String.format("%02d", minute);
    }
    
    private boolean isValid(String time, Set<Character> set) {
        for (char ch : time.toCharArray()) {
            if (!set.contains(ch) && ch != ':')  { 
                return false;
            }
        }
        return true;
    }
}