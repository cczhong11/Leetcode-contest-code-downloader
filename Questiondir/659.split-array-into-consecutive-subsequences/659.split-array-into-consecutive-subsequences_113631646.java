import java.util.SortedMap;
import java.util.TreeMap;


public class Solution {
public boolean isPossible(int[] nums) {
    if (nums.length == 0) {
      return true;
    }
    SortedMap<Integer, Integer> m = new TreeMap<>();
    for (int num : nums) {
      m.put(num, m.getOrDefault(num, 0) + 1);
    }
    while (m.size() > 0) {
      int smallest = m.firstKey();
      int m0 = 1;
      if (m.containsKey(smallest + 1) && m.containsKey(smallest + 2)) {
        if (m.get(smallest + 1) < m0) {
          return false;
        }
        m0 = m.get(smallest + 1);
        if (m.get(smallest + 2) < m0) {
          return false;
        }
        m0 = m.get(smallest + 2);
        int j = smallest + 3;
        while (true) {
          if (!m.containsKey(j) || m.get(j) < m0) {
            break;
          }
          m0 = m.get(j);
          j++;
        }
        for (int k = smallest; k < j; k++) {
          int newM = m.get(k) - 1;
          if (newM == 0) {
            m.remove(k);
          } else {
            m.put(k, newM);
          }
        }
      } else {
        return false;
      }
    }
    return true;
  }
}