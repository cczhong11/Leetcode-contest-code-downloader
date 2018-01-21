public class Solution {
    public int smallestFactorization(int a) {
        List<Integer> list = new ArrayList<>();
        int curr = a;
        while(curr >= 10) {
        	int prevCurr = curr;
        	for(int i = 9; i >= 1; i --) {
        		if(curr % i == 0) {
        			curr = curr / i;
        			list.add(i);
        			break;
        		}
        	}
        	if(curr == prevCurr) return 0;
        }
        list.add(curr);
        Collections.sort(list);
        long result = 0;
        for(int i = 0; i < list.size(); i ++) {
        	result *= 10;
        	result += list.get(i);
        }
        if(result > Integer.MAX_VALUE) return 0;
        return (int) result;
    }
}