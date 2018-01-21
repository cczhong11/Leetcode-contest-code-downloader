public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        LinkedList<Integer> ans = new LinkedList<>();
        int n = arr.size();
        if(x <= arr.get(0)) {
            for(int i = 0; i < k; ++i) ans.addLast(arr.get(i));
        }
        else if(x >= arr.get(n-1)) {
            for(int i = 0; i < k; ++i) ans.addFirst(arr.get(n-1-i));
        }
        else {
            int s = 0, e = n-1, m;
            while(s < e) {
                m = (s+e+1)/2;
                if(arr.get(m) < x) s = m;
                else e = m-1;
            }
            e = s+1;
            while(k > 0) {
                if(s < 0 || e < n && arr.get(e) - x < x - arr.get(s)) {
                    ans.addLast(arr.get(e++));
                }
                else {
                    ans.addFirst(arr.get(s--));
                }
                --k;
            }
        }
        return ans;
    }
}