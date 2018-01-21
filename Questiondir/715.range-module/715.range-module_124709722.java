class RangeModule {

 	private static class Node {
		int l, r;

		Node(int l, int r) {
			this.l = l;
			this.r = r;
		}
		
		public String toString() {
			return "(" + l + "," + r + ")";
		}
	}

	TreeSet<Node> set = new TreeSet<Node>((a, b) -> (a.l - b.l));

	public RangeModule() {

	}

	public void addRange(int left, int right) {
		if (set.isEmpty()) {
			set.add(new Node(left, right - 1));
		} else {
			Node node = new Node(left, right - 1);
			Node lower = set.lower(node);
			if (lower != null && lower.r + 1 >= node.l) {
				set.remove(lower);
				node.l = lower.l;
				node.r = Math.max(node.r, lower.r);
				// set.add(node);
			}
			Node ceiling = set.ceiling(node);
			while (ceiling != null && ceiling.l - 1 <= node.r) {
				set.remove(ceiling);
				node.r = Math.max(node.r, ceiling.r);
				ceiling = set.ceiling(node);
			}
			set.add(node);
		}
		//System.out.println(set);
	}

	public boolean queryRange(int left, int right) {
		Node node = new Node(left, right - 1);
		Node floor = set.floor(node);
		if (floor != null && floor.r >= node.r) {
			return true;
		} else {
			return false;
		}
	}

	public void removeRange(int left, int right) {
		Node node = new Node(left, right - 1);
		Node lower = set.lower(node);
		if (lower != null && lower.r >= node.l) {
			set.remove(lower);
			if (lower.l <= node.l - 1) {
				set.add(new Node(lower.l, node.l - 1));
			}
			set.add(new Node(node.l, lower.r));
		}
		
		
		Node ceiling = set.ceiling(node);
		while (ceiling != null && ceiling.l <= node.r) {
			//System.out.println("ceiling = " + ceiling.toString());
			set.remove(ceiling);
			if (node.r + 1 <= ceiling.r) {
				set.add(new Node(node.r + 1, ceiling.r));
			}
			ceiling = set.ceiling(node);
		}
		//System.out.println(set);
	}
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */