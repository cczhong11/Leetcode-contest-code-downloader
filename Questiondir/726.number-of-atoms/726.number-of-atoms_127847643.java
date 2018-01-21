import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.countOfAtoms("H2O"));
        System.out.println(sol.countOfAtoms("Mg(OH)2"));
        System.out.println(sol.countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println(sol.countOfAtoms("K4(ON(SO3)2)2Z"));
        System.out.println(sol.countOfAtoms("K4(ON(SO3)2)2ZYZ2"));
        System.out.println(sol.countOfAtoms("K4(ON(SO3)2)2(ZY)5Z2"));
    }


    private Map<String, Integer> doit(String s) {
        if (s.length() == 0) {
            return new HashMap<>();
        }

        if (Character.isAlphabetic(s.charAt(0))) {
            String atom = "" + s.charAt(0);
            int cnt = 0, i = 1;
            for (; i < s.length(); i++)
                if (Character.isLowerCase(s.charAt(i)))
                    atom += s.charAt(i);
                else break;
            for (; i < s.length(); i++)
                if (Character.isDigit(s.charAt(i)))
                    cnt = cnt * 10 + s.charAt(i) - '0';
                else break;

            Map<String, Integer> m = doit(s.substring(i));
            m.put(atom, m.getOrDefault(atom, 0) + Math.max(cnt, 1));
            return m;
        } else {
            int stack = 0;
            for (int i = 0; ; i++) {
                if (s.charAt(i) == '(') stack++;
                else if (s.charAt(i) == ')') stack--;

                if (stack == 0) {
                    Map<String, Integer> m = doit(s.substring(1, i));

                    int j = i + 1;
                    for (; j < s.length() && Character.isDigit(s.charAt(j)); j++) ;


                    int cnt = i + 1 == j ? 1 : Integer.parseInt(s.substring(i + 1, j));
                    for (String key : m.keySet())
                        m.put(key, m.get(key) * cnt);

                    Map<String, Integer> M = doit(s.substring(j));
                    Map<String, Integer> tmp;

                    if (m.size() > M.size()) {
                        tmp = m;
                        m = M;
                        M = tmp;
                    }
                    for (String key : m.keySet())
                        M.put(key, M.getOrDefault(key, 0) + m.get(key));
//                    System.out.println(M);
                    return M;
                }
            }
        }
    }

    public String countOfAtoms(String formula) {
        Map<String, Integer> map = doit(formula);
//        System.out.println(map);
        StringJoiner joiner = new StringJoiner("");
        for (String key : map.keySet().stream().sorted().collect(Collectors.toList())) {
            joiner.add(key);
            if (map.get(key) > 1) joiner.add("" + map.get(key));
        }
        return joiner.toString();
    }
}
