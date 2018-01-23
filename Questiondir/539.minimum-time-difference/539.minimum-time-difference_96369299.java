public class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Elem> list = new ArrayList<>();
        for (String s : timePoints) {
            list.add(new Elem(s));
        }

        Collections.sort(list, new Comparator<Elem>() {
            public int compare(Elem a, Elem b) {
                if (a.hour != b.hour) return a.hour - b.hour;
                else return a.mini - b.mini;
            }
        });

        Elem pre = list.get(list.size() - 1);
        Elem now = list.get(0);
        int res = (now.hour + 24 - pre.hour) * 60 + now.mini - pre.mini;
        for (int i = 1; i < list.size(); i ++) {
            pre = list.get(i - 1);
            now = list.get(i);
            int dif1 = (now.hour - pre.hour) * 60 + now.mini - pre.mini;
            if (res == -1 || dif1 < res) res = dif1;
        }
        return res;
    }

    class Elem {
        int hour, mini;
        public Elem(String s) {
            String[] parts = s.split(":");
            hour = Integer.parseInt(parts[0]);
            mini = Integer.parseInt(parts[1]);
        }
    }
}