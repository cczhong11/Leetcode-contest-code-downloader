class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<Step> dead = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            int[] temp = new int[4];
            for (int j = 0; j < deadends[i].length(); j++) {
                temp[j] = deadends[i].charAt(j) - '0';
            }
            dead.add(new Step(temp));
        }

        int[] t = new int[4];
        for (int i = 0; i < target.length(); i++) t[i] = target.charAt(i) - '0';

        Set<Step> visited = new HashSet<>();
        Step stepTarget = new Step(t);
        PriorityQueue<Step> pq = new PriorityQueue<>((o1, o2) -> o1.dis(t) - o2.dis(t));
        Step begin = new Step(new int[]{0, 0, 0, 0});
        visited.add(begin);
        pq.add(begin);

        while (!pq.isEmpty()) {
            Step poll = pq.poll();
            if (poll.equals(stepTarget)) {
                return poll.taken;
            }
            if (dead.contains(poll)) continue;

            for (int i = 0; i < 4; i++) {
                Step prev = new Step(poll);
                prev.taken++;
                prev.key[i] = (prev.key[i] + 10 - 1) % 10;
                if (!dead.contains(prev) && !visited.contains(prev)) {
                    pq.add(prev);
                    visited.add(prev);
                }

                Step next = new Step(poll);
                next.taken++;
                next.key[i] = (next.key[i] + 1) % 10;
                if (!dead.contains(next) && !visited.contains(next)) {
                    pq.add(next);
                    visited.add(next);
                }
            }
        }

        return -1;
    }

    private static class Step {
        int[] key = new int[4];
        int taken;

        public Step(Step that) {
            this.key = Arrays.copyOf(that.key, 4);
            this.taken = that.taken;
        }

        public Step(int[] key) {
            this.key = key;
            this.taken = 0;
        }

        public int dis(int[] target) {
            int res = 0;
            for (int i = 0; i < 4; i++) {
                int max = Math.max(target[i], key[i]);
                int min = Math.min(target[i], key[i]);
                res += Math.min(max - min, min + 10 - max);
            }
            return res + taken;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(key);
        }

        @Override
        public boolean equals(Object obj) {
            return Arrays.equals(key, ((Step)obj).key);
        }
    }

}