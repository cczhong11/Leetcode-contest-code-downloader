public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        List<List<Integer> > ret = new ArrayList<>();
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < matrix.size(); i++) {
            ret.add(new ArrayList<Integer>());
            for (int j = 0; j < matrix.get(i).size(); j++) {
                ret.get(i).add((matrix.get(i).get(j) == 0) ? 0 : Integer.MAX_VALUE);
                if (matrix.get(i).get(j) == 0) {
                    int[] toOffer = new int[2];
                    toOffer[0] = i;
                    toOffer[1] = j;
                    queue.offerLast(toOffer);
                }
            }
        }
        int rowM = matrix.size(), colM = matrix.get(0).size();
        while (!queue.isEmpty()) {
            int[] toPoll = queue.pollFirst();
            int row = toPoll[0], col = toPoll[1];
            int i = row - 1, j = col;
            if (i >= 0 && i < rowM && j >= 0 && j < colM) {
                if (ret.get(i).get(j) > ret.get(row).get(col)) {
                    ret.get(i).set(j, ret.get(row).get(col) + 1);
                    int[] toOffer = new int[2];
                    toOffer[0] = i;
                    toOffer[1] = j;
                    queue.offerLast(toOffer);
                }
            }
            i = row + 1; j = col;
            if (i >= 0 && i < rowM && j >= 0 && j < colM) {
                if (ret.get(i).get(j) > ret.get(row).get(col)) {
                    ret.get(i).set(j, ret.get(row).get(col) + 1);
                    int[] toOffer = new int[2];
                    toOffer[0] = i;
                    toOffer[1] = j;
                    queue.offerLast(toOffer);
                }
            }
            i = row; j = col + 1;
            if (i >= 0 && i < rowM && j >= 0 && j < colM) {
                if (ret.get(i).get(j) > ret.get(row).get(col)) {
                    ret.get(i).set(j, ret.get(row).get(col) + 1);
                    int[] toOffer = new int[2];
                    toOffer[0] = i;
                    toOffer[1] = j;
                    queue.offerLast(toOffer);
                }
            }
            i = row; j = col - 1;
            if (i >= 0 && i < rowM && j >= 0 && j < colM) {
                if (ret.get(i).get(j) > ret.get(row).get(col)) {
                    ret.get(i).set(j, ret.get(row).get(col) + 1);
                    int[] toOffer = new int[2];
                    toOffer[0] = i;
                    toOffer[1] = j;
                    queue.offerLast(toOffer);
                }
            }
        }
        return ret;
    }
}