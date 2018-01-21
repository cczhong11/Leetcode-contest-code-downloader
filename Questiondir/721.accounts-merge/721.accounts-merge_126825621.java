class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailMap = new HashMap<>();
        int p[] = new int[accounts.size()];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailMap.containsKey(email)) {
                    int index = emailMap.get(email);
                    int pindex = find(p, index);
                    int pi = find(p, i);
                    p[pi] = pindex;
                } else {
                    int pi = find(p, i);
                    p[i] = pi;
                    emailMap.put(email, pi);
                }
            }
        }

        List<Set<String>> tmpList = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            tmpList.add(new TreeSet<>());
        }
        for (int i = 0; i < accounts.size(); i++) {
            int pi = find(p, i);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                tmpList.get(pi).add(accounts.get(i).get(j));
            }
        }

        List<List<String>> resList = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            int pi = find(p, i);
            if (pi == i) {
                List<String> strList = new ArrayList<>();
                strList.add(accounts.get(i).get(0));
                for (String email : tmpList.get(pi)) {
                    strList.add(email);
                }
                resList.add(strList);
            }
        }
        return resList;
    }
    
    int find(int p[], int a) {
        if (p[a] == a) return a;
        int pa = find(p, p[a]);
        p[a] = pa;
        return pa;
    }

}