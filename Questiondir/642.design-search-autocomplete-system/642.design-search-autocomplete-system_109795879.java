	public class AutocompleteSystem {

		public class Datum
		{
			String s;
			int time;
			public Datum(String s, int time) {
				this.s = s;
				this.time = time;
			}
		}
		
		List<Datum> ds;
		String q = "";
		
	    public AutocompleteSystem(String[] sentences, int[] times) {
	    	int n = sentences.length;
	    	ds = new ArrayList<>();
	    	for(int i = 0;i < n;i++){
	    		ds.add(new Datum(sentences[i], times[i]));
	    	}
	    	Collections.sort(ds, new Comparator<Datum>(){
				public int compare(Datum a, Datum b){
					if(a.time != b.time)return -(a.time - b.time);
					return a.s.compareTo(b.s);
				}
			});
			
	    }
	    
	    public List<String> input(char c) {
	    	if(c != '#'){
		        q += c;
		        List<String> ret = new ArrayList<>();
		        for(Datum d : ds){
		        	if(d.s.startsWith(q)){
		        		ret.add(d.s);
		        		if(ret.size() == 3)break;
		        	}
		        }
		        return ret;
	    	}else{
	        	boolean done = false;
		        for(Datum d : ds){
		        	if(d.s.equals(q)){
		        		d.time++;
		        		done = true;
		        	}
		        }
		        if(!done){
		        	ds.add(new Datum(q, 1));
		        }
		    	Collections.sort(ds, new Comparator<Datum>(){
					public int compare(Datum a, Datum b){
						if(a.time != b.time)return -(a.time - b.time);
						return a.s.compareTo(b.s);
					}
				});
	        	q = "";
	        	return new ArrayList<>();
	        }
	    }
	}	
