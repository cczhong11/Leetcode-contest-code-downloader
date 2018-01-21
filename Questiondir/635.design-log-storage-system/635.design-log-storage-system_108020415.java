	public class LogSystem {

	    public LogSystem() {
	        list = new ArrayList<>();
	        ids = new ArrayList<>();
	    }
	    
	    List<Long> list;
	    List<Integer> ids;
	    
	    long go(String t)
	    {
	    	long ret = Long.parseLong(t.substring(0, 4));
	    	ret = ret * 100 + Long.parseLong(t.substring(5, 7));
	    	ret = ret * 100 + Long.parseLong(t.substring(8, 10));
	    	ret = ret * 100 + Long.parseLong(t.substring(11, 13));
	    	ret = ret * 100 + Long.parseLong(t.substring(14, 16));
	    	ret = ret * 100 + Long.parseLong(t.substring(17, 19));
	    	return ret;
	    }
	    
	    public void put(int id, String timestamp) {
	        ids.add(id);
	        list.add(go(timestamp));
	    }
	    
	    public List<Integer> retrieve(String s, String e, String gra) {
	    	long ss = go(s);
	    	long ee = go(e);
	    	long div = 1;
	        if(gra.equals("Year"))div = 10000000000L;
	        if(gra.equals("Month"))div = 100000000;
	        if(gra.equals("Day"))div = 1000000;
	        if(gra.equals("Hour"))div = 10000;
	        if(gra.equals("Minute"))div = 100;
	        List<Integer> ret = new ArrayList<>();
	        for(int i = 0;i < list.size();i++){
	        	long h = list.get(i)/div;
	        	if(ss/div <= h && h <= ee/div){
	        		ret.add(ids.get(i));
	        	}
	        }
	        return ret;
	    }
	}	