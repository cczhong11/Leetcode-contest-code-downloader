public class Solution {
    public String long_prefix(String a , String b){
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < a.length() ; i ++){
			if(a.charAt(i) == b.charAt(i)){
				sb.append(a.charAt(i));
			}else{
				break;
			}
		}
		return sb.toString();
	}

	public List<String> wordsAbbreviation(List<String> dict) {
		List<String> ans = new ArrayList<>();
		for(int i = 0 ; i < dict.size() ; i ++){
			String pre = "";
			boolean flag = false;
			String a = dict.get(i);
			for(int j = 0 ; j < dict.size() ; j ++){
				if(j == i) continue;
				String b = dict.get(j);
				if(a.length() == b.length()
						&& a.charAt(0) == b.charAt(0)
						&& a.charAt(a.length() - 1) == b.charAt(b.length() - 1)){
					flag = true;
					String prefix = long_prefix(a , b);
					if(prefix.length() > pre.length()){
						pre = prefix;
					}
				}
			}
			if(!flag){
				char head = a.charAt(0);
				char tail = a.charAt(a.length() - 1);
				String tmp = "" + head + (a.length() - 2) + tail;
				if(tmp.length() < a.length()) ans.add(tmp);
				else
					ans.add(a);
			}else{
				String head = pre+a.charAt(pre.length());
				if(head.length() == a.length()){
					ans.add(head);
				}else{
					char tail = a.charAt(a.length() - 1);
					int cnt = a.length() - 1 - head.length();
					String tmp = head+cnt+tail;
					if(tmp.length() < a.length()) ans.add(tmp);
					else
						ans.add(a);
				}
			}
		}
		return ans;
	}
}