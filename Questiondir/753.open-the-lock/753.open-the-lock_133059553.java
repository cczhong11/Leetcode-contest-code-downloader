import java.util.*;

public class Solution {

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String s : deadends)
            dead.add(s);
        if (target.equals("0000")) return 0;
        if (dead.contains("0000")) return -1;

        Map<String, Integer> dist = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        visited.add("0000");
        dist.put("0000", 0);
        queue.add("0000");
        while (!queue.isEmpty()) {
//            System.out.println(queue);
            String s = queue.poll();
            String ss = "";
            char[] chars = s.toCharArray();

            for (int i = 0; i < 4; i++) {
                char backup = chars[i];

                chars[i] = backup == '9' ? '0' : (char) (backup + 1);
                ss = String.valueOf(chars);
                if (!dead.contains(ss)) {
                    if (ss.equals(target)) return dist.get(s) + 1;
                    if (!visited.contains(ss)) {
                        visited.add(ss);
                        queue.add(ss);
                        dist.put(ss, dist.get(s) + 1);
                    }
                }


                chars[i] = backup == '0' ? '9' : (char) (backup - 1);
                ss = String.valueOf(chars);
                if (!dead.contains(ss)) {
                    if (ss.equals(target)) return dist.get(s) + 1;
                    if (!visited.contains(ss)) {
                        visited.add(ss);
                        queue.add(ss);
                        dist.put(ss, dist.get(s) + 1);
                    }
                }

                chars[i] = backup;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(sol.openLock(new String[]{"8888"}, "0009"));
        System.out.println(sol.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
        System.out.println(sol.openLock(new String[]{"0000"}, "8888"));
    }
}

