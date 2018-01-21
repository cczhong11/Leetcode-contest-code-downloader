class Solution {
    	public boolean checkValidString(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int left = 0;
        int star = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
        	if (c == '(') {
        		left++;
        	}
        	if (c == '*') {
        		star++;
        	}
        	if (c == ')') {
        		if (left > 0) {
        			left--;
        		} else if (star>0) {
        			star--;
        		} else {
        			return false;
        		}
        	}
        }
        int right = 0;
        star = 0;
        for (int i = arr.length-1; i >=0; i--) {
        	char c = arr[i];
        	if (c == ')') {
        		right++;
        	}
        	if (c == '*') {
        		star++;
        	}
        	if (c == '(') {
        		if (right>0) {
        			right--;
        		} else if (star>0) {
        			star--;
        		} else {
        			return false;
        		}
        	}
        }
        return true;
    }
}