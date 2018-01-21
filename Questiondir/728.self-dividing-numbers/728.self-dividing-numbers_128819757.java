class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = left; i <= right; ++i) {
            
            int tmp = i;
            boolean flag = true;
            while (tmp != 0) {
                
                if (tmp%10 == 0 || i%(tmp%10) != 0) flag = false;
                if (!flag) break;
                tmp = tmp/10;
                
            }
            if (flag) res.add(i);
            
        }
        return res;
        
    }
}