public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> m=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<paths.length;i++){
            String[] info=paths[i].split(" ");
            for(int x=1;x<info.length;x++){
                String rec=info[x];
                String content=rec.substring(rec.indexOf("(")+1,rec.length()-1);
                String path=info[0]+"/"+rec.substring(0,rec.indexOf("("));
                if(m.containsKey(content)){
                    if(m.get(content).size()==1){
                        result.add(m.get(content));
                    }
                }else{
                    m.put(content,new ArrayList<String>());
                }
                m.get(content).add(path);
            }
        }
        return result;
    }
}