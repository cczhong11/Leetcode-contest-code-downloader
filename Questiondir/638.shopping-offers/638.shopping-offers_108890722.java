public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> origin = new ArrayList<>();
        for(int l: needs) origin.add(0);
        map.put(encode(origin), 0);
        for(List<Integer> l: special) solve(map, l, needs);
        int ans = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> curr: map.entrySet()) {
            List<Integer> temp = parseList(curr.getKey());
            int val = curr.getValue();
            for(int i = 0; i < temp.size(); ++i) {
                val += (needs.get(i) - temp.get(i)) * price.get(i);
            }
            ans = Math.min(ans, val);
        }
        return ans;
    }
    
    private void solve(HashMap<String, Integer> map, List<Integer> offer, List<Integer> needs) {
        List<List<Integer>> buf = new ArrayList<>();
        for(Map.Entry<String, Integer> curr: map.entrySet()) {
            List<Integer> temp = parseList(curr.getKey());
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < needs.size(); ++i) {
                if(offer.get(i) > 0) min = Math.min(min, (needs.get(i)-temp.get(i))/offer.get(i));
            }
            for(int i = 1; i <= min; ++i) {
                List<Integer> cc = new ArrayList<>();
                for(int j = 0; j < temp.size(); ++j) {
                    cc.add(temp.get(j) + i*offer.get(j));
                }
                cc.add(curr.getValue() + i*offer.get(offer.size()-1));
                buf.add(cc);
            }
        }
        for(List<Integer> l: buf) {
            int val = l.remove(l.size()-1);
            String s = encode(l);
            map.put(s, Math.min(map.getOrDefault(s, Integer.MAX_VALUE), val));
        }
    }
    
    private String encode(List<Integer> l) {
        StringBuilder ans = new StringBuilder("");
        for(int i: l) ans.append(i).append(',');
        return ans.substring(0, ans.length()-1);
    }
    
    private List<Integer> parseList(String s) {
        List<Integer> ans = new ArrayList<>();
        String[] temp = s.split(",");
        for(String t: temp) ans.add(Integer.parseInt(t));
        return ans;
    }
}