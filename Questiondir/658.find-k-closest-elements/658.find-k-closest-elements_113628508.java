public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        int n = arr.size();
        int l = 0, r = n - 1;
        while(l < r) {
            int mid = (l + r) / 2;
            int cur = arr.get(mid);
            if(cur < x) {
                l = mid + 1;
            } else if(cur > x) {
                r = mid - 1;
            }
            else {
                l = mid;
                r = mid;
                break;
            }
        }
        if(r < 0)
            r = 0;
        if(l >= n)
            l = n - 1;
        if(r <= n - 1 && arr.get(r) <= x) {
            r = l + 1;
        } else if(l >= 0 && arr.get(l) >= x) {
            l = r - 1;
        } 
        for(int i = 0; i < k; i++) {
            if(l < 0) {
                result.add(arr.get(r++));
            } else if(r >= n) {
                result.add(arr.get(l--));
            } else {
                if(abs(arr.get(l) - x) <= abs(arr.get(r) - x)) {
                    result.add(arr.get(l--));
                } else {
                    result.add(arr.get(r++));
                }
            }
        }
        Collections.sort(result);
        return result;
    }
    
    private int abs(int x) {
        return x < 0 ? -x : x;
    }
}