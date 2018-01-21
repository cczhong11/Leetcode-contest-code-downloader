public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
        
        for (int i=0; i<paths.length; i++) {
            String tokens[] = paths[i].split(" ");
            
            for (int j=1; j<tokens.length; j++) {
                String words[] = tokens[j].split("[()]");
                String fileName = tokens[0] + "/" + words[0];
                String content = words[1];
                
                ArrayList<String> res = data.get(content);
                if (res == null)
                    res = new ArrayList<String>();
                    
                res.add(fileName);
                data.put(content, res);
            }
        }
        
        List<List<String>> r = new ArrayList<List<String>>();
        for (Map.Entry<String,ArrayList<String>> entry : data.entrySet()) {
            if (entry.getValue().size() > 1) {
                r.add(entry.getValue());
            }
        }
        
        return r;
    }
}