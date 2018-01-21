public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        
        for(int i=0;i<paths.length;i++){
            String[] entry = paths[i].split(" ");
            //System.out.println(Arrays.toString(entry));
            String dir = entry[0];
            
            for(int j=1;j<entry.length;j++){
                String[] content = entry[j].split("\\(");
                content[1] = content[1].substring(0, content[1].length()-1);
                //System.out.println(Arrays.toString(content));
                if(hm.containsKey(content[1])){
                    ArrayList<String> temp = hm.get(content[1]);
                    temp.add(dir+"/"+content[0]);
                    hm.put(content[1], temp);
                } else {
                    ArrayList<String> temp = new ArrayList<String>();
                    temp.add(dir+"/"+content[0]);
                    hm.put(content[1], temp);
                }
            }    
        }
        List<List<String>> ret = new ArrayList<List<String>>();
        for(ArrayList<String> e : hm.values()){
            if(e.size() > 1)
              ret.add(e);
        }
          
            
        return ret;
    }
}