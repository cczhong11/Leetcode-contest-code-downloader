public class Solution {
    	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n == 0)
			return true;
		else if (flowerbed.length == 0)
			return false;

		int count = 0;
		int pos = -2;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0)
				continue;

			for (int j = i - 2; j >= 0 && j >= pos + 2; j -= 2) {
				count++;
			}
			pos = i;
		}
		for (int j = flowerbed.length - 1; j >= 0 && j >= pos + 2; j -= 2) {
			count++;
		}
		return count >= n;
	}
}