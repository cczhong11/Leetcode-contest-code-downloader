class Solution {
	public int monotoneIncreasingDigits(int N) {
		char[] arr = Integer.toString(N).toCharArray();
		int len = arr.length;
		int i = 1;
		while (i < len) {
			if (arr[i] < arr[i - 1]) {// 出现逆序
				int j = i - 1;
				arr[j]--;
				while ((j >= 1 && arr[j] < arr[j - 1])) {// 需要借位或者出现逆序，需要继续回退
					arr[j] = '9';
					arr[--j]--;// 减1，如果原来是0，则要借位[不可能原来是0】
				}

				// 从i之后都是9
				while (i < len) {
					arr[i++] = '9';
				}
				return Integer.parseInt(new String(arr));
			}
			i++;
		}
		return N;
	}
}