public class Solution {
    int result = Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        dfs(price, special, needs, 0);
        return result;
    }
    
    private void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int cur) {
        int b = cur;
        for(int i = 0; i < needs.size(); i++) {
            b += price.get(i) * needs.get(i);
        }
        result = Math.min(result, b);
        
        for(int i = 0; i < special.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= needs.size(); j++) {
                
                if(j == needs.size()){
                    dfs(price, special, temp, cur + special.get(i).get(j));
                    break;
                }
                
                if(needs.get(j) < special.get(i).get(j))  break;
                else {
                    temp.add(needs.get(j) - special.get(i).get(j));
                }
            }
        }
    }
}