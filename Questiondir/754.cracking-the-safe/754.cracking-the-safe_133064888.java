class Solution {
        
    class Func {
        StringBuilder sb;
        int base;
        int next;
        int match;
        
        Func(StringBuilder sb, int base, int match) {
            this.sb = sb;
            this.base = base;
            this.match = match;
            this.next = 0;
        }
    }
    
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Func> stk = new Stack<Func>();
        for (int i = 0; i < n; i++)
            sb.append('0');
        int m = 1;
        for (int i = 0; i < n; i++)
            m *= k;
        int mask = m / k;
        int[] cover = new int[m];
        cover[0] = 1;
        
        stk.push(new Func(sb, 0, 1));
        
        while (true) {
            Func f = stk.peek();
            if (f.match == m) return f.sb.toString();
            int kbase = (f.base % mask) * k;
            int j = 0;
            for (j = f.next; j < k; j++)
                if (cover[kbase + j] == 0) break;
            if (j == k) {
                stk.pop();
                cover[f.base] = 0;
                continue;
            }
            cover[kbase + j] = 1;
            f.next = j + 1;
            StringBuilder nextsb = new StringBuilder(f.sb);
            nextsb.append((char)(j + '0'));
            stk.push(new Func(nextsb, kbase + j, f.match + 1));
        }
    }
}