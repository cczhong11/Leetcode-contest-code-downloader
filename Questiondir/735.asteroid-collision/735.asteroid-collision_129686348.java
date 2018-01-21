class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length <= 1) {
            return asteroids;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int a : asteroids) {
            if (deque.isEmpty() || deque.getFirst() < 0 || a > 0) {
                deque.addFirst(a);
            } else {
                while (!deque.isEmpty() && a != 0) {
                    int f = deque.getFirst();
                    if (f < 0) {
                        break;
                    } else if (f < -a) {
                        deque.removeFirst();
                    } else if (f == -a) {
                        deque.removeFirst();
                        a = 0;
                    } else if (f > a) {
                        a = 0;
                    }
                }
                if (a != 0) {
                    deque.addFirst(a);
                }
            }
        }
        int[] res = new int[deque.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = deque.removeLast();
        }
        return res;
    }
}