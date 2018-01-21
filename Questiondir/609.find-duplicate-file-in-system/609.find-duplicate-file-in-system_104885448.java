public class Solution {
    public Map<String,List<String>> map;
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        if(paths.length==0)return ans;
        map = new HashMap<>();
        for(String path : paths)loadFile(path);
        for(List<String> list : map.values()){
            if(list.size()<=1)continue;
            ans.add(new ArrayList<String>());
            for(String s : list){
                ans.get(ans.size()-1).add(s);
            }
        }
        return ans;
    }
    public void loadFile(String path){
        String[] files = path.split("[ ]");
        for(int i=1;i<files.length;i++){
            String content = files[i].substring(files[i].indexOf('('),files[i].indexOf(')')+1);
            String filename = files[i].substring(0,files[i].indexOf('('));
            if(!map.containsKey(content))map.put(content,new ArrayList<String>());
            map.get(content).add(files[0]+"/"+filename);
        }
    }
}