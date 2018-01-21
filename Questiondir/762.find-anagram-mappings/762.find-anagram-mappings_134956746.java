class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int n = A.length;
        int[] map = new int[n];
        HashMap<Integer, List<Integer>> maps = new HashMap<>();
        int i = 0;
        for(int b : B){
            List<Integer> list =  maps.getOrDefault(b, new ArrayList<Integer>());
            list.add(i);
            i++;
            maps.put(b, list);
        }
        i = 0;
        for(int a : A){
            List<Integer> list =  maps.get(a);
            map[i] = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            i++;
        }
        return map;
    }
}