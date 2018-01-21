public class Solution {
    private List<Integer> prices;
    private List<List<Integer>> specials;
    
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.prices = price;
        this.specials = new ArrayList<>();
        for (List<Integer> s : special) {
            int regular = 0;
            for (int i = 0; i < s.size() -1; i++) {
                regular += prices.get(i) * s.get(i);
            }
            int cheaper = regular - s.get(s.size()-1);
            if (cheaper > 0) {
                s.add(cheaper);
                this.specials.add(s);
            }
        }
        // System.out.println(specials);
        int priceNow = 0;
        for (int i = 0; i < needs.size(); i++) {
            priceNow += prices.get(i) * needs.get(i);
        }
        return priceNow - find(needs);
    }
    
    public int find(List<Integer> needs) {
        int cheaper = 0;
        // System.out.println(needs);
        more: for (List<Integer> s : this.specials) {
            // System.out.println("s " + s);
            int regular = 0;
            List<Integer> next = new ArrayList<>(needs);
            for (int i = 0; i < s.size() - 2; i++) {
                next.set(i, next.get(i) - s.get(i));
                if (next.get(i) < 0) {
                    continue more;
                }
            }
            int x = s.get(s.size()-1);
            // System.out.println("x: " + x);
            cheaper = Math.max(cheaper, find(next) + x);
        }
        return cheaper;
    }
}