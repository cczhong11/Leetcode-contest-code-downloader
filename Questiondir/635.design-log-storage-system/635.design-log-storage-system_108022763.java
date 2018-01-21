class Time {
    public static String[] GRA = new String[] {"Year", "Month", "Day", "Hour", "Minute", "Second"};
    public int ts[] = new int[6];
    public Time(String input) {
        String arr[] = input.split(":");
        for (int i = 0; i < arr.length; i++) {
            ts[i] = Integer.valueOf(arr[i]);
        }
    }
    static int comp(Time t1, Time t2, String gra) {
        int index = -1;
        for (int i = 0; i < GRA.length; i++)
            if (gra.equals(GRA[i])) index = i;

        for (int i = 0; i <= index; i++) {
            if (t1.ts[i] != t2.ts[i])
                return Integer.compare(t1.ts[i], t2.ts[i]);
        }
        return 0;
    }
}

public class LogSystem {
    List<Integer> ids = new ArrayList<>();
    List<Time> time = new ArrayList<>();
    
    public LogSystem() {

    }

    public void put(int id, String timestamp) {
        ids.add(id);
        time.add(new Time(timestamp));
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> ans = new ArrayList<>();
        Time st = new Time(s);
        Time et = new Time(e);
        for (int i = 0; i < ids.size(); i++) {
            Time curr = time.get(i);
            if (Time.comp(st, curr, gra) <= 0 && Time.comp(et, curr, gra) >= 0)
                ans.add(ids.get(i));
        }
        return ans;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */