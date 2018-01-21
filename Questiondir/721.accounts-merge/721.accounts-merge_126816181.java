class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        List<Set<Integer>> g = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String s = accounts.get(i).get(j);
                if (!map.containsKey(s))
                    map.put(s, new ArrayList<>());
                map.get(s).add(i);
            }
            g.add(new HashSet<>());
        }
        for (String k : map.keySet()) {
            for (int v1 : map.get(k)) {
                for (int v2: map.get(k)) {
                    if (v1!=v2)
                        g.get(v1).add(v2);
                }
            }
        }
        boolean[] checked = new boolean[n];
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (checked[i])
                continue;
            checked[i] = true;
            String name = accounts.get(i).get(0);
            Set<String> res1 = new TreeSet<>();
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(i);
            while (!q.isEmpty()) {
                int u = q.removeFirst();
                for (int j = 1; j < accounts.get(u).size(); j++)
                    res1.add(accounts.get(u).get(j));
                for (int v : g.get(u)) {
                    if (!checked[v]) {
                        checked[v] = true;
                        q.add(v);
                    }
                }
            }
            List<String> res = new ArrayList<>();
            res.add(name);
            res.addAll(res1);
            result.add(res);
        }
        return result;
    }
}