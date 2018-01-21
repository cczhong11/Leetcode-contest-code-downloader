public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        Collections.sort(arr);
        
        int i = 0;
        int n = arr.size();
        while (i < n && arr.get(i) < x) {
            i++;
        }
        i--;
        int j = i + 1;
        //System.out.println(i);
        List<Integer> res = new ArrayList<>();
        
        while (res.size() < k) {
            // if (i >= 0 && j < n) {
            //     System.out.println(arr.get(i) + " " + arr.get(j));
            //     System.out.println(x - arr.get(i) + ", " + (arr.get(j) - x));
            // }
            if (j >= n || i >= 0 && x - arr.get(i) <= arr.get(j) - x) {
                res.add(arr.get(i));
                i--;
            } else {
                res.add(arr.get(j));
                j++;
            }
        }
        Collections.sort(res);
        return res;
    }
}