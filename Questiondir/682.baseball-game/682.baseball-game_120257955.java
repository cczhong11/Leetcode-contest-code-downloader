class Solution {
    public int calPoints(String[] ops) {
        List<Integer> a = new ArrayList<>();
        for(String s : ops){
            if(s.charAt(0) == '+'){
                int len = a.size();
                int fir = a.get(len - 1), sec = a.get(len - 2);
                a.add(fir + sec);
            }
            else if(s.charAt(0) == 'D'){
                int fir = a.get(a.size() - 1);
                a.add(2 * fir);
            }
            else if(s.charAt(0) == 'C')
                a.remove(a.size() - 1);
            else
                a.add(Integer.valueOf(s));
        }
        int ans = 0;
        for(int i : a)
            ans += i;
        return ans;
    }
}