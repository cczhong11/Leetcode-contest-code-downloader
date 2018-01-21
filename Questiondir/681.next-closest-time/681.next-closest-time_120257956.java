class Solution {
    public String nextClosestTime(String time) {
        String[] times = time.split(":");
        int hour = Integer.valueOf(times[0]);
        int min = Integer.valueOf(times[1]);

        Set<Integer> set = new HashSet<>();

        for (char c : time.toCharArray()) {
            if (c != ':') {
                set.add(c - '0');
            }
        }

        List<Integer> minues = getValid(set, 59);
        List<Integer> hours = getValid(set, 23);

        int nextMin = getNext(minues, min);
        if (nextMin < min) {
            int nextHour = getNext(hours, hour);
            return toTime(nextHour, nextMin);
        } else {
            return toTime(hour, nextMin);
        }
    }
    
     private List<Integer> getValid(Set<Integer> set, int max) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            if (set.contains(i / 10) && set.contains(i % 10)) {
                list.add(i);
            }
        }
        //System.err.println(list.toString());
        return list;
    }

    private int getNext(List<Integer> list, int a) {
        int index = list.indexOf(a);
        if (index + 1 < list.size()) {
            return list.get(index + 1);
        } else {
            return list.get(0);
        }
    }

    private String toTime(int h, int m) {
        String s = "";
        if (h < 10) {
            s += "0" + h;
        } else {
            s += h;
        }

        s += ":";

        if (m < 10) {
            s += "0" + m;
        } else {
            s += m;
        }
        return s;
    }

}