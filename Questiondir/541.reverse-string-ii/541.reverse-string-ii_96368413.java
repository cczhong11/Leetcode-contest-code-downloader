public class Solution {
    public void swap(char[] str , int i , int j){
		char tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}

	public void reverse(char[] str , int left , int right){
		while(left <= right){
			swap(str , left , right);
			left ++;
			right --;
		}
	}

	public String reverseStr(String s, int k) {
		char[] str = s.toCharArray();
		int idx = 0;
		int cur = 0;
		while(idx < str.length){
			if(idx + k <= str.length){
				if(cur == 0){
					int left = idx;
					int right = idx + k - 1;
					reverse(str , left , right);
					idx = idx + k;
				}else{
					idx = idx + k;
				}
			}else{
				if(cur == 0){
					int left = idx;
					int right = str.length - 1;
					reverse(str , left , right);
					break;
				}else{
					break;
				}
			}
			cur = (cur + 1) % 2;
		}
		return new String(str);
	}
}