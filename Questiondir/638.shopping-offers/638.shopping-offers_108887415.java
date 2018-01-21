public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < price.size(); i++) {
            sum += price.get(i) * needs.get(i);
        }
        sum = getMin(price, special, needs, sum, 0, sum);
        return sum;
    }
    public int getMin(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int curMin, int index, int curSum) {
        if (index == special.size()) {
            curMin = Math.min(curMin, curSum);
            return curMin;
        }
        List<Integer> sl = special.get(index);
        int maxNum = 7;
        int originalPrice = 0;
        for (int i = 0; i < needs.size(); i++) {
            if (sl.get(i) == 0) {
                continue;
            }
            //System.out.print(needs.get(i) + " ");
            maxNum = Math.min(maxNum, needs.get(i) / sl.get(i));
            originalPrice += sl.get(i) * price.get(i);
        }
        //System.out.println("");
        if (maxNum == 7 || originalPrice <= sl.get(needs.size())) {
            return getMin(price, special, needs, curMin, index + 1, curSum);
        }
        for (int i = 1; i <= maxNum; i++) {
            List<Integer> newNeed = new ArrayList<Integer>();
            for (int j = 0; j < needs.size(); j++) {
                newNeed.add(needs.get(j) - i * sl.get(j));
            }
            int newSum = curSum - (originalPrice - sl.get(needs.size())) * i;
            curMin = getMin(price, special, newNeed, curMin, index + 1, newSum);
        }
        curMin = getMin(price, special, needs, curMin, index + 1, curSum);
        return curMin;
    }
}