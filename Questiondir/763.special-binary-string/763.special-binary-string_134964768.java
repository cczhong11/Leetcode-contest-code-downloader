class Solution {
    
    class Expression {
        Expression[] expressions;
        public Expression(char[] S) {
            
        }
    }
    public String makeLargestSpecial(String S) {
        return new String(makeLargestSpecial(S.toCharArray()));
    }
    
    public char[] makeLargestSpecial(char[] S) {
        LinkedList<char[]> list = new LinkedList<char[]>();
        int i=0, j=0, n = S.length;
        if (n==0) return S;
        while(i<n) {
            int count = 0;
            do {
                if(S[j]=='1') count += 1;
                else count -= 1;
                j += 1;
            } while(count != 0);
            int m = j - i;
            char[] next = new char[m-2];
            for(j=1;j<m-1;j++) next[j-1] = S[i+j];
            list.add(makeLargestSpecial(next));
            i += m;
            j = i;
        }
        int m = list.size();
        char[][] toSort = new char[m][];
        for(i=0;i<m;i++) toSort[i] = list.removeFirst();
        // printc(toSort);
        Arrays.sort(toSort, new Comparator<char[]>() {
           public int compare(char[] a, char[] b) {
               int na = a.length, nb = b.length, nc = Math.min(na, nb);
               for(int k=0;k<nc;k++) {
                   if(a[k]>b[k]) return -1;
                   if(a[k]<b[k]) return 1;
               }
               if (na>nb) return -1;
               if (na<nb) return 1;
               return 0;
           } 
        });
        // printc(toSort);
        int cur = 0;
        char[] ret = new char[n];
        for(i=0;i<m;i++) {
            ret[cur++] = '1';
            for(j=0;j<toSort[i].length;j++) {
                ret[cur++] = toSort[i][j];
            }
            ret[cur++] = '0';
        }
        return ret;
    }
    
    private void printc(char[][] c) {
        int n = c.length;
        StringBuffer s = new StringBuffer().append("{\n");
        for(int i=0;i<n;i++) {
            s.append("   [").append(new String(c[i])).append("]\n");
        }
        s.append("}");
        System.out.println(s);
    }
}