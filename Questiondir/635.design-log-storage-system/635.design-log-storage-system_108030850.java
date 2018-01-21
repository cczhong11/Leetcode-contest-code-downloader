public class LogSystem {

     List<List<Integer>> ts = new ArrayList<>();
    List<Integer> ids = new ArrayList<>();

    static final String [] str = {"Year", "Month", "Day", "Hour", "Minute","Second"};
    public LogSystem() {
    }
    
    private List<Integer> convertor(String ts) {
        String arr[] = ts.split(":");
        List<Integer> res = new ArrayList<>();
        for (String str : arr) {
            res.add(Integer.valueOf(str));
        }
        return res;
    }
    public void put(int id, String timestamp) {
        ts.add(convertor(timestamp));
        ids.add(id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> startTime = convertor(s);
        List<Integer> endTime = convertor(e);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < ts.size(); i++) {
            List<Integer> curr = ts.get(i);
            if (comp(startTime, curr, gra) <= 0 && comp(endTime, curr, gra) >= 0) {
                ans.add(ids.get(i));
            }
        }
        return ans;
    }
    
    private int comp(List<Integer> t1, List<Integer> t2, String gra) {
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(gra)) {
                index = i;
                break;
            }
        }
        for (int i = 0; i <= index; i++) {
            int cmp = Integer.compare(t1.get(i), t2.get(i));
            if (cmp != 0) {
                return cmp;
            }
        }
        return 0;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */