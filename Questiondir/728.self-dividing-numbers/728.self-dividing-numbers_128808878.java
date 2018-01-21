class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        A:
        for(int i = left; i <= right; i++){
            int num = i;
            while(num != 0){
                int c = num % 10;
                num /= 10;
                if(c == 0 || i % c != 0){
                    continue A;
                }
            }
            ans.add(i);
        }
        return ans;
    }
}