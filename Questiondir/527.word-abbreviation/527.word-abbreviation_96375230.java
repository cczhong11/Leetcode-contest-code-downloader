public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        int len=dict.size();
        String[] ans=new String[len];
        int[] cnt=new int[len];
        for (int i=0;i<len;i++) {
            cnt[i]=1;
            ans[i]=makeString(dict.get(i), 1);
        }
        for (int i=0;i<len;i++) {
            while (true) {
                HashSet<Integer> set=new HashSet<>();
                for (int j=i+1;j<len;j++) {
                    if (ans[j].equals(ans[i])) set.add(j);
                }
                if (set.isEmpty()) break;
                set.add(i);
                for (int k: set) {
                    cnt[k]++;
                    ans[k]=makeString(dict.get(k), cnt[k]);
                }
            }
        }
        return Arrays.asList(ans);
    }

    private String makeString(String s, int k) {
        if (k>=s.length()-2) return s;
        StringBuilder builder=new StringBuilder();
        builder.append(s.substring(0, k));
        builder.append(s.length()-1-k);
        builder.append(s.charAt(s.length()-1));
        return builder.toString();
    }
}