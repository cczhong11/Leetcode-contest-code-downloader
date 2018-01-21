class Solution {
    int sum = '0' + '1';
    public int flipLights(int n, int m) {
        if (n == 0 || m == 0) {
            return 1;
        }
        if (n > 6) { // pattern cycle = 6
            n = 6;
        }
        char[] str = new char[n];
        Arrays.fill(str, '1');
        Set<String> set = new HashSet<>();
        set.add(new String(str));
        for (int i = 0; i < m; i++) {
            Set<String> next = new HashSet<>();
            for (String s : set) {
                next.add(flip(s, 0, 1));
                next.add(flip(s, 1, 2));
                next.add(flip(s, 0, 2));
                next.add(flip(s, 0, 3));
            }
            set = next;
        }
        return set.size();
    }
    private String flip(String s, int start, int inc) {
        // System.out.println("input = " + s + ", start = " + start + ", inc = " + inc);
        char[] ary = s.toCharArray();
        int len = ary.length;
        for (int i = start; i < len; i += inc) {
            ary[i] = (char)(sum - ary[i]);
        }
        // System.out.println("string = " + new String(ary));
        return new String(ary);
    }
}