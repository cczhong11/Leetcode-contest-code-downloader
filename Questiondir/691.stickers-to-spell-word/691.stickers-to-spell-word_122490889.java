class Solution {
	boolean[] c;
	List<word> words;
	HashMap<String,Integer> dp;
	class word{
		int[] counts;
		public word(String s) {
			counts = new int[26];
			for (int i=0;i<26;++i)
				counts[i]=0;
			for (int i=0;i<s.length();++i) {
				counts[s.charAt(i)-'a']++;
				c[s.charAt(i)-'a']=true;
			}
		}
		
		public String toString() {
			StringBuffer ss = new StringBuffer();
			for (int i=0;i<26;++i) {
				char c = (char) (i + 'a');
				for (int j=0;j<counts[i];++j) {
					ss.append(c);
				}
			}
			return ss.toString();
		}
		
		public word(word w) {
			counts = new int[26];
			for (int i=0;i<26;++i){
				counts[i]=w.counts[i];
			}
		}
		
		public boolean check(word w) {
			boolean t = false;
			for (int i=0;i<26;++i) {
				if (counts[i]<w.counts[i]) {
					t=true;
					break;
				}
			}
			return t;
		}
	}
	
    public int minStickers(String[] stickers, String target) {
        c = new boolean[26];
        for (int i=0;i<26;++i)
        	c[i]=false;
        words = new ArrayList<word>();
        for (String sticker:stickers) {
        	words.add(new word(sticker));
        }
        
        dp = new HashMap<String, Integer>();
        
        for (int i=0;i<target.length();++i) {
        	int chr = target.charAt(i)-'a';
        	if (c[chr]==false)
        		return -1;
        }
        
        return dfs(new word(target));
        
    }

	private int dfs(word word) {
		String w = word.toString();
		if (dp.containsKey(w))
			return dp.get(w);
		
		if (w.length()==0) {
			dp.put(w, 0);
			return 0;
		}
		int min = 32767;
		for (word wo:words) {
			word newWord = new word(word);
			boolean t = false;
			for (int i=0;i<26;++i) {
				if (wo.counts[i]>0)
					if (newWord.counts[i]>0) {
						t = true;
						newWord.counts[i]=Math.max(0, newWord.counts[i]-wo.counts[i]);
					}
			}
			if (!t)
				continue;
			else {
				min = Math.min(min, 1+dfs(newWord));
			}
		}
		
		dp.put(w, min);
		
		return min;
	}
}