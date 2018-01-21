	public class Solution {
	    public List<List<String>> findDuplicate(String[] paths) {
	    	Map<String, List<String>> map = new HashMap<>();
	        for(String path : paths){
	        	String[] sp = path.split(" ");
	        	for(int i = 1;i < sp.length;i++){
	        		int br = sp[i].indexOf('(');
	        		String file = sp[0] + "/" + sp[i].substring(0, br);
	        		String cont = sp[i].substring(br);
	        		if(!map.containsKey(cont)){
	        			map.put(cont, new ArrayList<>());
	        		}
	        		map.get(cont).add(file);
	        	}
	        }
	        List<List<String>> ret = new ArrayList<>();
	        for(String k : map.keySet()){
	        	if(map.get(k).size() >= 2){
	        		ret.add(map.get(k));
	        	}
	        }
	        return ret;
	    }
	}	
