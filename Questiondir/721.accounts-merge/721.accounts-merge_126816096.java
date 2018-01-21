class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, String> email2name = new HashMap<>();
        for (List<String> lst : accounts) {
            for (int i = 1; i < lst.size(); i++) {
                String email1 = lst.get(i);
                if (!map.containsKey(email1)) {
                    map.put(email1, new HashSet<String>());
                }
                email2name.put(email1, lst.get(0));
                for (int j = i + 1; j < lst.size(); j++) {
                    String email2 = lst.get(j);
                    if (!map.containsKey(email2)) {
                        map.put(email2, new HashSet<String>());
                    }
                    map.get(email1).add(email2);
                    map.get(email2).add(email1);
                }
            }
        }
        
        HashSet<String> seen = new HashSet<String>();
        List<List<String>> ans = new ArrayList<>();
        for (String email : email2name.keySet()) {
            if (!seen.contains(email)) {
                HashSet<String> cmp = getComponent(map, email);
                List<String> lst = new ArrayList(cmp);
                Collections.sort(lst);
                lst.add(0, email2name.get(email));
                ans.add(lst);
                seen.addAll(lst);
            }
        }
        return ans;
    }
    
    public HashSet<String> getComponent(HashMap<String, HashSet<String>> map, String start) {
        HashSet<String> seen = new HashSet<String>();
        Queue<String> q = new ArrayDeque<>();
        q.offer(start);
        seen.add(start);
        while (!q.isEmpty()) {
            String curr = q.poll();
            for (String next : map.get(curr)) {
                if (!seen.contains(next)) {
                    q.offer(next);
                    seen.add(next);
                }
            }
        }
        return seen;
    }
    
    public String first(HashSet<String> set) {
        for (String s : set) {
            return s;
        }
        return null;
    }
    
    public static class Node {
        public ArrayList<Node> next = new ArrayList<Node>();
    }
}
