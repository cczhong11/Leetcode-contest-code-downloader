class Solution {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        List<String> res = new ArrayList<>();
        StringBuilder toAdd = new StringBuilder();
        for (String s : source) {
            s += "\n";
            for (int i = 0; i < s.length()-1; i++) {
                char c = s.charAt(i);
                char c2 = s.charAt(i+1);
                if (!inBlock) {
                    if (c=='/') {
                        if (c2=='/') {
                            break;
                        } else if (c2=='*') {
                            inBlock = true;
                            i++;
                        } else {
                            toAdd.append(c);
                        }
                    } else {
                        toAdd.append(c);
                    }
                } else if (c=='*'&&c2=='/') {
                    i++;
                    inBlock = false;
                }
            }
            if (!inBlock && toAdd.length() > 0) {
                res.add(toAdd.toString());
                toAdd = new StringBuilder();
            }
        }
        return res;
    }
}