public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String,List<String>> content_dir = new HashMap<String,List<String>>();
        for(String path : paths){
            String[] sp = path.split(" ");
            String head_dir =  sp[0];
            for(int i=1;i<sp.length;i++){
                int firstIndex = sp[i].indexOf("(");
                String content = sp[i].substring(firstIndex);
                if(!content_dir.containsKey(content)){
                    content_dir.put(content, new ArrayList<String>());
                }
                content_dir.get(content).add(head_dir+"/"+sp[i].substring(0, firstIndex));
            }
        }
        for(List<String> v : content_dir.values()){
            if(v.size()>1){
                res.add(v);
            }
        }
        return res;
    }
}