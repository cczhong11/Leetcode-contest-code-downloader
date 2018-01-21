public class Solution {
        static class IntIntPair implements Comparable<IntIntPair> {
            public final int first;
            public final int second;
    
            public IntIntPair(int first, int second) {
                this.first = first;
                this.second = second;
            }
    
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                IntIntPair pair = (IntIntPair) o;
                return first == pair.first && second == pair.second;
            }
    
            public int hashCode() {
                int result = first;
                result = 31 * result + second;
                return result;
            }
    
            public String toString() {
                return "(" + first + "," + second + ")";
            }
    
            @SuppressWarnings ({"unchecked"})
            public int compareTo(IntIntPair o) {
                int value = Integer.compare(first, o.first);
                if (value != 0) {
                    return value;
                }
                return Integer.compare(second, o.second);
            }
        }
        public static int[] zAlgorithm(CharSequence s) {
        int length = s.length();
        int[] z = new int[length];
        int left = 0, right = 0;
        for (int i = 1; i < length; i++) {
            if (i > right) {
                int j;
                for (j = 0; i + j < length && s.charAt(i + j) == s.charAt(j); j++);
                z[i] = j;
                left = i;
                right = i + j - 1;
            } else if (z[i - left] < right - i + 1)
                z[i] = z[i - left];
            else {
                int j;
                for (j = 1; right + j < length && s.charAt(right + j) == s.charAt(right - i + j); j++);
                z[i] = right - i + j;
                left = i;
                right = right + j - 1;
            }
        }
        return z;
    }
    public static ArrayList<Integer> zsearch(String s, String target){
        String concat = target + "~" + s;
        int[] z = zAlgorithm(concat);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < z.length; i++) {
            if(z[i] == target.length()){
                res.add(i - target.length() - 1);
            }
        }
        return res;
    }
    public String addBoldTag(String big, String[] dict) {
        ArrayList<IntIntPair> segments = new ArrayList<>();
        for (String d : dict) {
            ArrayList<Integer> occursAt = zsearch(big, d);
            for (int idx : occursAt) {
                segments.add(new IntIntPair(idx, idx + d.length() - 1));
            }
        }
        if (segments.isEmpty()) return big;
        Collections.sort(segments);
        ArrayList<IntIntPair> res = new ArrayList<>();
        IntIntPair pre = segments.get(0);
        for (int i = 0; i < segments.size(); i++) {
            IntIntPair curr = segments.get(i);
            if (curr.first > pre.second + 1) {
                res.add(pre);
                pre = curr;
            } else {
                pre = new IntIntPair(pre.first, Math.max(pre.second, curr.second));
            }
        }
        res.add(pre);
        StringBuilder ans = new StringBuilder();
        int reached = 0;
        for (IntIntPair seg : res) {
            if (seg.first > reached) {
                ans.append(big.substring(reached, seg.first));
            }
            ans.append("<b>");
            ans.append(big.substring(seg.first, seg.second + 1));
            ans.append("</b>");
            reached = seg.second + 1;
        }
        if (reached < big.length()) ans.append(big.substring(reached));
        return ans.toString();
    }
}