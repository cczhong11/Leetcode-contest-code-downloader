import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSystem {
    Map<Integer, String> map = new HashMap<>();
    public LogSystem() {

    }

    public void put(int id, String timestamp) {
        map.put(id, timestamp);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        s = process(s, gra, "0000:00:00:00:00:00");
        e = process(e, gra, "9999:12:31:23:59:59");
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (s.compareTo(entry.getValue()) <= 0 && e.compareTo(entry.getValue()) >= 0) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private String process(String s, String gra, String remain) {
        switch (gra) {
            case "Year":
                return s.substring(0, 4) + remain.substring(4);
            case "Month":
                return s.substring(0, 7) + remain.substring(7);
            case "Day":
                return s.substring(0, 10) + remain.substring(10);
            case "Hour":
                return s.substring(0, 13) + remain.substring(13);
            case "Minute":
                return s.substring(0, 16) + remain.substring(16);
            case "Second":
                return s.substring(0, 19) + remain.substring(19);

        }
        throw new RuntimeException();
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */