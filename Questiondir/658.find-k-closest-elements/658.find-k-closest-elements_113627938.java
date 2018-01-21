public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int index = Collections.binarySearch(arr, x);
        int l = index;
        if (index < 0) {
            index = -index - 1;
            l = index - 1;
            arr.add(index, x);
        }
        int r = index + 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            if (l < 0) {
                ans.add(arr.get(r++));
            } else if (r >= arr.size()) {
                ans.add(arr.get(l--));
            } else if (dist(x, arr.get(l)) <= dist(x, arr.get(r))) {
                ans.add(arr.get(l--));
            } else {
                ans.add(arr.get(r++));
            }
        }
        Collections.sort(ans);
        return ans;
    }
    
    public int dist(int a, int b) {
        return Math.abs(a - b);
    }
}