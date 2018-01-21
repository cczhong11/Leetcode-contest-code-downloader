class Solution {
    public int maxProfit(int[] prices, int fee) {
        int ret = 0;
        prices = findExtreme(dedupe(prices));
        int n = prices.length;
        int min = prices[0], max = prices[0];
        for(int i=1;i<n;i++) {
            if(prices[i]>max) max = prices[i];
            else {
                if(prices[i]<max-fee || prices[i]<min) {
                    int tmp = max - min - fee;
                    if(tmp>0) ret += tmp;
                    min = prices[i];
                    max = prices[i];
                }
            }
        }
        int tmp = max - min - fee;
        if(tmp>0) ret += tmp;
        return ret;
    }
    
    public int[] dedupe(int[] prices) {
        int n = prices.length;
        LinkedList<Integer> list = new LinkedList();
        for(int i=0;i<n;i++) {
            if(i==0 || prices[i]!=prices[i-1]) list.add(prices[i]);
        }
        int m = list.size();
        int[] ret = new int[m];
        for(int i=0;i<m;i++) ret[i] = list.removeFirst();
        return ret;
    }
    
    public int[] findExtreme(int[] prices) {
        int n = prices.length;
        LinkedList<Integer> list = new LinkedList();
        for(int i=0;i<n;i++) {
            if(i==0 || i==n-1) list.add(prices[i]);
            else {
                if(prices[i]>prices[i-1] && prices[i]>prices[i+1]) list.add(prices[i]);
                else if(prices[i]<prices[i-1] && prices[i]<prices[i+1]) list.add(prices[i]);
            }
        }
        int m = list.size();
        int[] ret = new int[m];
        for(int i=0;i<m;i++) ret[i] = list.removeFirst();
        return ret;
    }
}