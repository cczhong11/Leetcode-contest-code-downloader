public class Solution {

	public boolean detectCapitalUse(String word) {
		
		int length = word.length();
		if (length == 1)
			return true;
		else {
			if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
				for (int i = 1;i < word.length();i ++) {
					if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
						continue;
					} else
						return false;
				}
				return true;
			} else {
				if (word.charAt(1) >= 'a' && word.charAt(1) <= 'z') {
					for (int i = 2;i < word.length();i ++) {
						if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
							continue;
						} else
							return false;
					}
					return true;	 
				} else {
					for (int i = 2;i < word.length();i ++) {
						if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
							continue;
						} else
							return false;
					}
					return true;
				}
			}
		}
        
    }

}