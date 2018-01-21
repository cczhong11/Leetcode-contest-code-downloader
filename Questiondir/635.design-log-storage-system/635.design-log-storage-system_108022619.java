public class LogSystem {

    TreeMap<String, Integer> map = new TreeMap<>();
    Map<String, Integer>g = new HashMap<>();
    public LogSystem() {
        g.put("Year", 4);
        g.put("Month", 7);
        g.put("Day", 10);
        g.put("Hour", 13);
        g.put("Minute", 16);
        g.put("Second", 19);
    }
    
    public void put(int id, String timestamp) {
        map.put(timestamp, id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        int end = g.get(gra);
        s = s.substring(0, end);
        int tmp = 1+Integer.parseInt(e.substring(end-2, end));
        e = e.substring(0, end-2)+String.format("%1$02d", tmp);
        List<Integer> result = new ArrayList<>();
        String cur = map.containsKey(s)?s:map.higherKey(s);
        while(cur!=null && cur.compareTo(e)<0){
            result.add(map.get(cur));
            cur = map.higherKey(cur);
        }
        return result;
    }
    
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */