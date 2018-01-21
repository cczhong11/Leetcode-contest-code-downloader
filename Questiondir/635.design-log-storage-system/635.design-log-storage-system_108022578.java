public class LogSystem {

    public LogSystem() {
        
    }
    
    
 	public static class Pair {
		public int id;
		public String timestamp;
		public Pair(int id, String timestamp) {
			this.id = id;
			this.timestamp = timestamp;
		}
		
		public static String get(String timestamp, String granularity) {
			String[] s = timestamp.split(":");
			if (granularity.toLowerCase().equals("year")) {
				return s[0];
			} else if (granularity.toLowerCase().equals("month")) {
				return s[0] + ":" + s[1];
			} else if (granularity.toLowerCase().equals("day")) {
				return s[0] + ":" + s[1] + ":" + s[2];
			} else if (granularity.toLowerCase().equals("hour")) {
				return s[0] + ":" + s[1] + ":" + s[2] + ":" + s[3];
			} else if (granularity.toLowerCase().equals("minute")) {
				return s[0] + ":" + s[1] + ":" + s[2] + ":" + s[3] + ":" + s[4];
			} else {
				return s[0] + ":" + s[1] + ":" + s[2] + ":" + s[3] + ":" + s[4] + ":" + s[5];
			}
		}
	}
	private List<Pair> list = new ArrayList<>();
	public void put(int id, String timestamp) {
		list.add(new Pair(id, timestamp));

	}

	public List<Integer> retrieve(String s, String e, String gra) {
		List<Integer> res = new ArrayList<>();
		s = Pair.get(s, gra);
		e = Pair.get(e, gra);
		for (Pair pair : list) {
			String t = Pair.get(pair.timestamp, gra);
			if (t.compareTo(s) >= 0 && t.compareTo(e) <= 0) {
				res.add(pair.id);
			}
		}
		return res;
	}
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */