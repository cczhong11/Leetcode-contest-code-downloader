public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) {
			return true;
		}
		
		int count = 0;
		boolean lastTaken = false;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 1) {
				lastTaken = true;
			} else {
				if (lastTaken) {
					lastTaken = false;
				} else {
					lastTaken = true;
					if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
						count++;
						if (count >= n) {
							return true;
						}
					}
				}

			}
		}

		return false;

	}
}