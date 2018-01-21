class Solution {
    public int[] anagramMappings(int[] a, int[] b) {
        int len = a.length;
        int[] res = new int[len];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i =0; i < len; i++){
            if(!map.containsKey(b[i])){
                map.put(b[i], new ArrayList<>());
            }
            map.get(b[i]).add(i);
        }
        for(int i = 0; i < len; i++){
            res[i] = map.get(a[i]).get(map.get(a[i]).size() -1);
            map.get(a[i]).remove(map.get(a[i]).size()-1);
        }
        return res;
    }
}