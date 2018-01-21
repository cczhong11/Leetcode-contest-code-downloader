class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        Set<Integer> posSet = new HashSet<>();
        for (int i = 0; i < positions.length; i++) {
            posSet.add(positions[i][0]);
            posSet.add(positions[i][0] + positions[i][1] - 1);
        }
        List<Integer> posList = new ArrayList<>(posSet);
        Collections.sort(posList);

        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < posList.size(); i++) {
            posMap.put(posList.get(i), i);
        }

        int h[] = new int[posMap.size()];
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < positions.length; i++) {
            int l = posMap.get(positions[i][0]);
            int r = posMap.get(positions[i][0] + positions[i][1] - 1);
            int maxH = 0;
            for (int j = l; j <= r; j++) {
                maxH = Math.max(maxH, h[j]);
            }
            int nh = maxH + positions[i][1];
            for (int j = l; j <= r; j++) {
                h[j] = nh;
            }
            
            max = Math.max(max, nh);
            ans.add(max);
        }
        return ans;
    }
}