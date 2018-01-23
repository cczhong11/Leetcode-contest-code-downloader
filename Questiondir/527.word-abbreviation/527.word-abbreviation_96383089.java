public class Solution {
    
    public class TreeNode {
        char val;
        int cnt;
        Map<Character, TreeNode> next;
        public TreeNode(char c) {
            val = c;
            cnt = 0;
            next = new HashMap<Character, TreeNode>();
        }
    }
    
    private TreeNode buildPTree(List<String> list) {
        TreeNode root = null;
        for(String w : list) {
            if(root == null) {
                root = new TreeNode(w.charAt(0));
            }
            root.cnt++;
            int j = 1;
            TreeNode current = root;
            while(j < w.length()) {
                char c = w.charAt(j);
                if(!current.next.containsKey(c)) {
                    TreeNode node = new TreeNode(c);
                    current.next.put(c, node);
                }
                current.next.get(c).cnt++;
                current = current.next.get(c);
                j++;
            }
        }
        return root;
    }
    
    private String longestSolo(String w, TreeNode root) {
        String ans = "" + w.charAt(0);
        int j = 1;
        TreeNode current = root;
        while(j < w.length()) {
            char c = w.charAt(j);
            ans += c;
            if(current.next.get(c).cnt == 1) {
                break;
            } else {
                current = current.next.get(c);
            }
            j++;
        }
        return ans;
    }
    
    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> ans = new ArrayList<String>();
        if(dict.size() > 0) {
            Map<String, Integer> wMap = new HashMap<String, Integer>();
            Map<String, List<String>> lMap = new HashMap<String, List<String>>();
            for(int i = 0; i < dict.size(); i++) {
                String w = dict.get(i);
                wMap.put(w, i);
                if(w.length() > 3) {
                    int tail = w.length();
                    String key = w.charAt(0) + String.valueOf(tail-2) + w.charAt(tail-1);
                    if(lMap.containsKey(key)) {
                        lMap.get(key).add(w);
                    } else {
                        List<String> list = new ArrayList<String>();
                        list.add(w);
                        lMap.put(key, list);
                    }
                } else {
                    List<String> list = new ArrayList<String>();
                    list.add(w);
                    lMap.put(w, list);
                }
                ans.add(w);
            }
            for(String key : lMap.keySet()) {
                List<String> list = lMap.get(key);
                TreeNode root = buildPTree(list);
                if(list.size() == 1) {
                    int id = wMap.get(list.get(0));
                    ans.set(id, key);
                } else {
                    for(String w : list) {
                        String prefix = longestSolo(w, root);
                        String nKey = w;
                        if(prefix.length() + 2 < w.length()) {
                            int save = w.length() - prefix.length() - 1;
                            nKey = prefix + String.valueOf(save) + w.charAt(w.length()-1);
                        }
                        int id = wMap.get(w);
                        ans.set(id, nKey);
                    }
                }
            }
        }
        return ans;
    }
}