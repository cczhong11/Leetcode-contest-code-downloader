public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
         List<List<String>> res = new ArrayList<>();
        if(paths==null||paths.length==0)
        	return res;
        HashMap<String,Set<String>> hm = new HashMap<String,Set<String>>();
        for(String str:paths){
        	String []tmp = str.split(" ");
        	if(tmp.length<2)
        		continue;
        	String dir = tmp[0];
        	for(int i = 1;i<tmp.length;i++){
        		String ts = tmp[i];
        		String sts[] = ts.split("\\(");
        		String name = sts[0];
        		String con = sts[1].substring(0, sts[1].length()-1);
        		if(!hm.containsKey(con)){
        			hm.put(con, new HashSet<String>());
        			hm.get(con).add(dir+"/"+name);
        		}
        		else{
        			hm.get(con).add(dir+"/"+name);
        		}
        	}
        }
        Iterator<String> iter = hm.keySet().iterator();
        while(iter.hasNext()){
        	Set<String> tmp = hm.get(iter.next());
        	if(tmp.size()>1){
	        	List<String> lt = new ArrayList<>();
	        	Iterator<String> iter1 = tmp.iterator();
	        	while(iter1.hasNext()){
	        		//sb.append(iter1.next()+",");
	        		lt.add(iter1.next());
	        	}
	        	//sb.substring(0, sb.length()-1);
	        	//res.add(sb.toString());
	        	res.add(lt);
        	}
        }
        return res;
    }
}