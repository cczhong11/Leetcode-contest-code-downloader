class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        int len = source.length;
        int i = 0;
        while(i < len){
            String line = source[i];
            if(line.indexOf("//") < 0 && line.indexOf("/*") < 0) {
                ans.add(line);
                i++;
            } else if(line.indexOf("//") >= 0 && line.indexOf("/*") < 0) {
                removeLine(line, ans);
                i++;
            } else if(line.indexOf("/*") >= 0 && line.indexOf("//") < 0) {
                i = removeBlock(source, ans, i, line);
                
            } else {
                int idx1 = line.indexOf("//");
                int idx2 = line.indexOf("/*");
                if(idx1 < idx2) {
                    removeLine(line, ans);
                    i++;
                } else {
                    i = removeBlock(source, ans, i, line);
                }
            }
        }
        return ans;
    }
    
    public void removeLine(String line, List<String> ans) {     
        int idx = line.indexOf("//");
        String newLine = line.substring(0,idx);
        if(newLine.length() > 0) {
            ans.add(newLine);
        } 
    }
    
    public int removeBlock(String[] source, List<String> ans, int i, String line) {
        int nextLine = findClose(i, source);
        int leftIdx = line.indexOf("/*");
        int rightIdx = source[nextLine].indexOf("*/");
        if(nextLine == i) {
           rightIdx = source[nextLine].indexOf("*/", leftIdx + 2); 
        }
               
        String newLine = line.substring(0,leftIdx) + source[nextLine].substring(rightIdx + 2,source[nextLine].length());
        if(newLine.length() > 0) {
            source[nextLine] = newLine;
            return nextLine;
        }
        return nextLine + 1;
    }
    
    public int findClose(int start, String[] source) {
        String line = source[start];
        int leftIdx = line.indexOf("/*");
        if(leftIdx + 2 < line.length() && line.charAt(leftIdx + 2) == '/') {
           if(line.indexOf("*/", leftIdx + 2) >= 0) {
               return start;
           }
            start++;
        }
        
        while(start < source.length) {
            if(source[start].indexOf("*/") >= 0) {
                return start;
            }
            start++;
        }
        return start;
    }
}