public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int index = findClosest(arr, 0, arr.size(), x);
        ArrayList<Integer> rv = new ArrayList<>();
        
        int i = index;
        int j = index+1;
        while(rv.size() < k) {
            if (i<0) {
                rv.add(arr.get(j));
                j++;
            } else if (j >= arr.size()) {
                rv.add(arr.get(i));
                i--;
            } else {
                if (Math.abs(arr.get(i)-x) <= Math.abs(arr.get(j)-x)) {
                    rv.add(arr.get(i));
                    i--;
                } else {
                    rv.add(arr.get(j));
                    j++;
                }
            }
        }
        
        Collections.sort(rv);
        return rv;
    }
    
    private int findClosest(List<Integer> arr, int begin, int end, int x) {
        if (end == begin + 1) return begin;
        
        int mid = (begin+end)/2;
        
        if (arr.get(mid) <= x && arr.get(mid+1) >= x) return mid;
        
        if (x < arr.get(mid)) {
            return findClosest(arr, begin, mid, x);
        } else {
            return findClosest(arr, mid, end, x);
        }
    }
}