public class Solution {
    class Ele {
        public int key;
        public int row, col;
        Ele(int key, int row, int col) {
            this.key = key;
            this.row = row;
            this.col = col;
        }
    }
    class MultiSet {
        TreeSet<Ele> s = new TreeSet<>(new Comparator<Ele>() {
            @Override
            public int compare(Ele o1, Ele o2) {
                if (o1.key != o2.key)
                    return Integer.compare(o1.key, o2.key);
                return Integer.compare(o1.row, o2.row);
            }
        });
        void add(int key, int row, int col) {
            s.add(new Ele(key, row, col));
        }

        Ele pop() {
            Ele e = small();
            s.remove(e);
            return e;
        }

        Ele small() {
            return s.first();
        }

        Ele big() {
            return s.last();
        }
    }
    public int[] smallestRange(int[][] nums) {
        int k = nums.length;
        MultiSet multiSet = new MultiSet();
        for (int i = 0; i < k; i++) {
            multiSet.add(nums[i][0], i, 0);
        }
        int[] ans = new int[] {0, Integer.MAX_VALUE - 1};
        while (true) {
            int left = multiSet.small().key;
            int right = multiSet.big().key;
            if (right - left < ans[1] - ans[0]) {
                ans[0] = left;
                ans[1] = right;
            }
            Ele ele = multiSet.pop();
            if (ele.col + 1 <= nums[ele.row].length - 1) {
                multiSet.add(nums[ele.row][ele.col + 1], ele.row, ele.col + 1);
            }
            else break;
        }
        return ans;
    }
}