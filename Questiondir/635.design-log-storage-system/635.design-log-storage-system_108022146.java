public class LogSystem {
    List<Pair> list = new ArrayList<>();

    public LogSystem() {

    }

    public void put(int id, String timestamp) {
        list.add(new Pair(id, timestamp));
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        Collections.sort(list, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.time.compareTo(b.time);
            }
        });
        String[] ss = s.split(":");
        String[] se = e.split(":");

        if (gra.equals("Year")) {
            s = s.substring(0, 4);
            e = e.substring(0, 4);
        } else if (gra.equals("Month")) {
            s = s.substring(0, 7);
            e = e.substring(0, 7);
        } else if (gra.equals("Day")) {
            s = s.substring(0, 10);
            e = e.substring(0, 10);
        } else if (gra.equals("Hour")) {
            s = s.substring(0, 13);
            e = e.substring(0, 13);
        } else if (gra.equals("Minute")) {
            s = s.substring(0, 16);
            e = e.substring(0, 16);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i ++) {
            Pair pair = list.get(i);
            String ts = pair.time.substring(0, s.length());
            if (ts.compareTo(e) > 0) break;
            if (ts.compareTo(s) >= 0) {
                res.add(pair.id);
            }
        }

        return res;
    }
}

class Pair {
    String time;
    int id;
    public Pair(int id, String time) {
        this.id = id;
        this.time = time;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */