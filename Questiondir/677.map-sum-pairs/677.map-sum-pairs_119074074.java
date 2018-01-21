import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class MapSum {

    Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (String s : map.keySet())
            if (s.startsWith(prefix))
                sum += map.get(s);
        return sum;
    }

    public static void main(String[] args) {
        MapSum sol = new MapSum();
        sol.insert("apple", 3);
        System.out.println(sol.sum("ap"));
        System.out.println(sol.sum(""));
        sol.insert("app", 2);
        System.out.println(sol.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */