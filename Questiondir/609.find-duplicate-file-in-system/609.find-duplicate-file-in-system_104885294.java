public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        
        Map<String,String> map = new HashMap<String,String>();
        
        List<List<String>> result = new ArrayList<List<String>>();
        
        Map<String,List<String>> temp = new HashMap<String,List<String>>();
        
        for (String path : paths) {
            String[] items = path.split(" ");
            String directory = items[0];
            
            for (int i=1; i<items.length; i++) {
                int left = items[i].indexOf("(");
                int right = items[i].indexOf(")");
                String fileName = items[i].substring(0,left);
                String content = items[i].substring(left+1,right);
                
                if (map.containsKey(content)) {
                    if (temp.containsKey(content)) {
                        temp.get(content).add(directory+"/"+fileName);
                    } else {
                        List<String> files = new ArrayList<String>();
                        files.add(directory+"/"+fileName);
                        files.add(map.get(content));
                        temp.put(content,files);
                    }
                }
                
                map.put(content,directory+"/"+fileName);
            }
        }
        
        for (List<String> lists : temp.values()) {
            if (lists.size()>1) {
               result.add(lists); 
            }
        }
        
        return result;
    }
}