import sun.rmi.log.ReliableLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSystem {

    public LogSystem() {
        map = new HashMap<>();
    }

    Map<Integer, String> map;

    public void put(int id, String timestamp) {
        map.put(id, timestamp);
    }

    private int getLen(String gra) {
        int len = 0;
        len += 4;
        if (gra.equalsIgnoreCase("year")) return len;
        len += 3;
        if (gra.equalsIgnoreCase("month")) return len;
        len += 3;
        if (gra.equalsIgnoreCase("day")) return len;
        len += 3;
        if (gra.equalsIgnoreCase("hour")) return len;
        len += 3;
        if (gra.equalsIgnoreCase("minute")) return len;
        return len + 3;
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<>();
        int len = getLen(gra);
        s = s.substring(0, len);
        e = e.substring(0, len);
        
        for (int i : map.keySet()) {
            String str = map.get(i).substring(0, len);
            if (str.compareTo(s) >= 0 && str.compareTo(e) <= 0) res.add(i);
        }
        return res;
    }


    public static void main(String[] args) {
        LogSystem a = new LogSystem();

    }
}