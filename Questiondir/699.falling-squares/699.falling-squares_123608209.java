class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        LinkedList<int[]> ranges = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int current_max = 0;
        for (int i = 0; i < n; ++i) {
            int left = positions[i][0];
            int side_length = positions[i][1];
            int right = left + side_length;
            int height = side_length;
            for (int[] range : ranges) {
                if (left < range[1] && right >  range[0]) {
                    height = Math.max(range[2] + side_length, height);
                }
            }
            ranges.offer(new int[] {left, right, height});
            current_max = Math.max(current_max, height);
            result.add(current_max);
        }
        return result;
    }
}