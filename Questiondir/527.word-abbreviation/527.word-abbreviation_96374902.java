	public class Solution {
	    public List<String> wordsAbbreviation(List<String> dict) {
	    	int n = dict.size();
	    	List<String> ret = new ArrayList<>();
	    	for(int i = 0;i < n;i++)ret.add(null);
	    	for(char c = 'a';c <= 'z';c++){
		    	List<String> q = new ArrayList<>();
		    	for(int i = 0;i < n;i++){
		    		if(dict.get(i).charAt(dict.get(i).length()-1) == c){
		    			q.add(dict.get(i));
		    		}
		    	}
		    	List<String> res = go2(q);
		    	int p = 0;
		    	for(int i = 0;i < n;i++){
		    		if(dict.get(i).charAt(dict.get(i).length()-1) == c){
		    			ret.set(i, res.get(p++));
		    		}
		    	}
	    	}
	    	return ret;
	    }
	    
	    private List<String> go2(List<String> dict)
	    {
	    	int n = dict.size();
	    	int[] all = new int[n];
	    	for(int i = 0;i < n;i++){
	    		all[i] = dict.get(i).length();
	    	}
	    	Arrays.sort(all);
	    	List<String> ret = new ArrayList<>();
	    	for(int i = 0;i < n;i++)ret.add(null);
	    	for(int ind = 0;ind < n;ind++){
	    		if(ind == 0 || all[ind] != all[ind-1]){
	    			int len = all[ind];
			    	List<String> q = new ArrayList<>();
			    	for(int i = 0;i < n;i++){
			    		if(dict.get(i).length() == len){
			    			q.add(dict.get(i));
			    		}
			    	}
			    	List<String> res = go(q);
			    	int p = 0;
			    	for(int i = 0;i < n;i++){
			    		if(dict.get(i).length() == len){
			    			ret.set(i, res.get(p++));
			    		}
			    	}
	    		}
	    	}
	    	return ret;
	    }
	    
	    private List<String> go(List<String> dict){
	    	int n = dict.size();
	    	TrieByLink trie = new TrieByLink();
	        char[][] ss = new char[n][];
	        for(int i = 0;i < n;i++){
	        	ss[i] = dict.get(i).toCharArray();
	        	trie.add(ss[i]);
	        }
	        int[] dp = new int[trie.gen];
	        TrieByLink.Node[] ns = trie.toArray();
	        for(int i = trie.gen-1;i >= 0;i--){
	        	TrieByLink.Node cur = ns[i];
	        	dp[i] = cur.hit;
    			for(TrieByLink.Node ch = cur.firstChild;ch != null; ch = ch.next){
    				dp[i] += dp[ch.id];
    			}
	        }
	        List<String> ret = new ArrayList<>();
	        for(int i = 0;i < n;i++){
	        	TrieByLink.Node cur = trie.root;
	        	int len = ss[i].length;
	        	inner:
	        	for(int j = 0;j < ss[i].length;j++){
	        		if(dp[cur.id] == 1){
	        			len = j;
	        			break;
	        		}
	    			for(TrieByLink.Node ch = cur.firstChild;ch != null; ch = ch.next){
	    				if(ch.c == ss[i][j]){
	    					cur = ch;
	    					continue inner;
	    				}
	    			}
	    			assert false;
	        	}
	        	
	        	if(len <= 1)len = 1;
	        	if(ss[i].length-1-len >= 2){
	        		String r = dict.get(i).substring(0, len) + (ss[i].length-1-len) + dict.get(i).charAt(ss[i].length-1);
	        		ret.add(r);
	        	}else{
	        		ret.add(dict.get(i));
	        	}
	        }
	        return ret;
	    }
	    
	    public class TrieByLink {
	    	public Node root = new Node((char)0, 0);
	    	public int gen = 1;
	    	public final char[] atoz = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	    	
	    	public class Node
	    	{
	    		public int id;
	    		public char c;
	    		public Node next, firstChild;
	    		public int hit = 0;
	    		
	    		public Node fail;
	    		
	    		public Node(char c, int id)
	    		{
	    			this.id = id;
	    			this.c = c;
	    		}
	    		
	    		public String toString(String indent)
	    		{
	    			StringBuilder sb = new StringBuilder();
	    			sb.append(indent + id + ":" + c);
	    			if(hit != 0)sb.append(" H:" + hit);
	    			if(fail != null)sb.append(" F:" + fail.id);
	    			sb.append("\n");
	    			for(Node c = firstChild;c != null; c = c.next){
	    				sb.append(c.toString(indent + "  "));
	    			}
	    			return sb.toString();
	    		}
	    	}
	    	
	    	public void add(char[] s)
	    	{
	    		Node cur = root;
	    		Node pre = null;
	    		for(char c : s){
	    			pre = cur; cur = cur.firstChild;
	    			if(cur == null){
	    				cur = pre.firstChild = new Node(c, gen++);
	    			}else{
	    				for(;cur != null && cur.c != c;pre = cur, cur = cur.next);
	    				if(cur == null)cur = pre.next = new Node(c, gen++);
	    			}
	    		}
	    		cur.hit++;
	    	}
	    	
	    	public Node[] toArray()
	    	{
	    		Node[] ret = new Node[gen];
	    		ret[0] = root;
	    		for(int i = 0;i < gen;i++){
	    			Node cur = ret[i];
	    			if(cur.next != null)ret[cur.next.id] = cur.next;
	    			if(cur.firstChild != null)ret[cur.firstChild.id] = cur.firstChild;
	    		}
	    		return ret;
	    	}
	    	
	    	public String toString()
	    	{
	    		return root.toString("");
	    	}
	    }

	}
