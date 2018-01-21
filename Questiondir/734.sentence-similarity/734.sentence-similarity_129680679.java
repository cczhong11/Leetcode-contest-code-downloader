import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();


    }


    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;

        Map<String, Set<String>> similar = new HashMap<>();
        for (String[] pair : pairs) {
            String a = pair[0];
            String b = pair[1];
            similar.putIfAbsent(a, new HashSet<>());
            similar.putIfAbsent(b, new HashSet<>());
            similar.get(a).add(b);
            similar.get(b).add(a);
        }

        for (int i = 0; i < words1.length; i++) {
            String a = words1[i];
            String b = words2[i];

            if (a.equals(b)) continue;
            if (similar.containsKey(a) && similar.get(a).contains(b)) continue;
            if (similar.containsKey(b) && similar.get(b).contains(a)) continue;

            return false;
        }

        return true;
    }
}