class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> emails = new HashMap<>();
        int[] roots = new int[accounts.size()];
        Arrays.fill(roots, -1);
        for (int i=0; i<accounts.size(); i++) {
            for (int j=1; j<accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emails.containsKey(email)) {
                    union(roots, i, emails.get(email));
                } else {
                    emails.put(email, i);
                }
            }
        }
        Map<Integer,Integer> newPositions = new HashMap<>();
        int num = 0;
        for (int i=0; i<accounts.size(); i++) {
            if (roots[i] < 0) {
                newPositions.put(i, num++);
            }
        }
        List<List<String>> results = new ArrayList<>(num);
        for (int i=0; i<num; i++) {
            results.add(new ArrayList<>());
        }
        for (Map.Entry<Integer,Integer> entry : newPositions.entrySet()) {
            results.get(entry.getValue()).add(accounts.get(entry.getKey()).get(0));
        }
        for (Map.Entry<String,Integer> entry : emails.entrySet()) {
            Integer position = newPositions.get(getRoot(roots, entry.getValue()));
            results.get(position).add(entry.getKey());
        }
        for (int i=0; i<results.size(); i++) {
            Collections.sort(results.get(i));
        }
        return results;
    }
    private void union(int[] roots, int i, int j) {
        i = getRoot(roots, i);
        j = getRoot(roots, j);
        if (i == j) {
            return;
        } else if (roots[i] < roots[j]) {
            roots[i] += roots[j];
            roots[j] = i;
        } else {
            roots[j] += roots[i];
            roots[i] = j;
        }
    }
    private int getRoot(int[] roots, int i) {
        return (roots[i] < 0) ? i : (roots[i] = getRoot(roots, roots[i]));
    }
}