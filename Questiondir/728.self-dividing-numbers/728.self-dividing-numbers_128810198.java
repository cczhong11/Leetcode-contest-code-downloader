class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        LinkedList<Integer> ret = new LinkedList<Integer>();
        for(int i=left;i<=right;i++) {
            if (isSDN(i)) ret.add(i);
        }
        return ret;
    }
    
    public boolean isSDN(int number) {
        String s = Integer.toString(number);
        char[] c = s.toCharArray();
        for(char ch : c) {
            if (ch=='0') return false;
            int digit = (ch - '0');
            if (number%digit!=0) return false;
        }
        return true;
    }
}