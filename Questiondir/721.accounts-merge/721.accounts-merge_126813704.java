import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.accountsMerge(Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")
        )));
    }

    Map<String, String> parents;

    String find(String s) {
        if (!parents.get(s).equals(s)) {
            parents.put(s, find(parents.get(s)));
        }
        return parents.get(s);
    }

    void union(String a, String b) {
        parents.put(find(a), find(b));
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parents = new HashMap<>();

        Map<String, String> emailToName = new HashMap<>();
        Set<String> cands = new HashSet<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                emailToName.put(account.get(i), account.get(0));

                parents.putIfAbsent(account.get(i), account.get(i));
                cands.add(account.get(i));
                if (i > 1) {
                    union(account.get(i - 1), account.get(i));
                }
            }
        }

        Map<String, List<String>> res = new HashMap<>();
        for (String email : cands) {
            String root = find(email);
            res.putIfAbsent(root, new ArrayList<>());
            res.get(root).add(email);
        }

        List<List<String>> resres = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : res.entrySet()) {
            List<String> list = new ArrayList<>();
            list.addAll(entry.getValue());
            Collections.sort(list);
            list.add(0, emailToName.get(entry.getKey()));
            resres.add(list);
        }
        return resres;
    }

}
