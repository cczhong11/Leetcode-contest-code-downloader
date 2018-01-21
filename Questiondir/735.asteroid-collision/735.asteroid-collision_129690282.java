class Solution {
    public int[] asteroidCollision(int[] asteroids) {
		int des = 0;
		while (des > 0 || asteroids.length > 0 ) {
			des = 0;
			for (int i = 0; i < asteroids.length - 1; i++) {
				int left = asteroids[i];
				int right = asteroids[i+1];
				if (left > 0 && right < 0) {
					int rightSize = right * -1;
					if (left > rightSize) {
						asteroids[i+1] = left;
						asteroids[i] = 0;
						des++;
					} else if (left < rightSize) {
						asteroids[i] = right;
						asteroids[i+1] = 0;
						des++;
        			} else {
        				asteroids[i] = 0;
        				asteroids[i+1] = 0;
        				des+=2;
        			}
        		}
        	}
			if (des == 0) {
				return asteroids;
			}
			int[] next = new int[asteroids.length - des];
			int j = 0;
			for (int i = 0; i < asteroids.length; i++) {
				if (asteroids[i] != 0) {
					next[j] = asteroids[i];
					j++;
				}
			}
			asteroids = next;
        }
        return asteroids;
    }
}