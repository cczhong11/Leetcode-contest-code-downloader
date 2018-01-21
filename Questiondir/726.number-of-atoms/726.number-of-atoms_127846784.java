class Solution {
    public String countOfAtoms(String formula) {
        Map<String,Integer> cnts = new HashMap<>();
        solve(formula, 0, formula.length()-1, cnts, 1);
        List<String> keys = new ArrayList<>(cnts.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key);
            if (cnts.get(key) > 1) {
                sb.append(cnts.get(key));
            }
        }
        return sb.toString();
    }
    private void solve(String s, int p, int r, Map<String,Integer> cnts, int times) {
        for (int i=p; i<=r; ) {
            if ('(' == s.charAt(i)) {
                int j = i;
                for (int state=0; j<=r; j++) {
                    if ('(' == s.charAt(j)) {
                        state++;
                    } else if (')' == s.charAt(j) && --state == 0) {
                        break;
                    }
                }
                int jj = j+1;
                while (jj <= r && s.charAt(jj) >= '0' && s.charAt(jj) <= '9') {
                    jj++;
                }
                if (jj == j+1) {
                    solve(s, i+1, j-1, cnts, times);
                } else {
                    solve(s, i+1, j-1, cnts, times*Integer.parseInt(s.substring(j+1, jj)));
                }
                i = jj;
            } else {
                int j = i+1;
                while (j <= r && s.charAt(j) >= 'a' && s.charAt(j) <= 'z') {
                    j++;
                }
                int jj = j;
                while (jj <= r && s.charAt(jj) >= '0' && s.charAt(jj) <= '9') {
                    jj++;
                }
                int cnt = (jj == j)? times : times*Integer.parseInt(s.substring(j, jj));
                String key = s.substring(i, j);
                if (!cnts.containsKey(key)) {
                    cnts.put(key, cnt);
                } else {
                    cnts.put(key, cnts.get(key)+cnt);
                }
                i = jj;
            }
        }
    }
}