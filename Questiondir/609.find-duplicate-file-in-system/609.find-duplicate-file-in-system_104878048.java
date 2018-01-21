public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        //content against path
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        for(int i=0;i<paths.length;i++){
            buildMap(map,paths[i].split(" "));
        }
        List<List<String>> result=new ArrayList<List<String>>();
        for(String key:map.keySet()){
            List<String> curr=map.get(key);
            if(curr.size()>1){
                result.add(curr);
            }
        }
        return result;
    }
    public void buildMap(Map<String,List<String>> map,String[] s){
        for(int i=1;i<s.length;i++){
            int index=s[i].indexOf('(');
            String filename=s[i].substring(0,index);
            String content=s[i].substring(index+1,s[i].length()-1);
            if(!map.containsKey(content)){
                map.put(content,new ArrayList<String>());
            }
            map.get(content).add(s[0]+"/"+filename);
        }
    }
}