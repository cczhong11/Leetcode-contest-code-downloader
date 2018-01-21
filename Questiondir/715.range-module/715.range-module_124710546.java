class RangeModule {

        class SegNode {
            int left, right, mid;
            SegNode lc, rc;
            boolean modified;
            boolean covered;
            boolean empty;
            public SegNode(int left, int right){
                this.left=left;
                this.right=right;
                this.mid=left+(right-left)/2;
                this.empty=true;
            }
            void addRange(int left, int right){
//                log.info("addRange({}, {}) on ({})", left, right, this);
                if (left<=this.left&&right>=this.right){
                    if (!covered) {
                        covered = true;
                        modified=true;
                        empty=false;
                    }
                } else {
                    pushdown();
                    if (left<=mid) this.lc.addRange(left, right);
                    if (right>mid)this.rc.addRange(left, right);
                    maintain();
                }
//                log.info("after addRange({}, {}) on ({}", left, right, this);
            }
            void maintain(){
                this.covered=this.lc.covered&&this.rc.covered;
                this.empty=this.lc.empty&&this.rc.empty;
            }
            void removeRange(int left, int right){
//                log.info("remove ({}, {}) on ({})", left, right, this);
                if (left<=this.left&&right>=this.right){
                    if (!empty){
                        empty=true;
                        covered=false;
                        modified=true;
                    }
                } else {
                    pushdown();
                    if (left<=mid)this.lc.removeRange(left, right);
                    if (right>mid)this.rc.removeRange(left, right);
                    maintain();

                }
//                log.info("after remove ({}, {}) on ({})", left, right, this);
            }
            boolean query(int left, int right){
//                log.info("query ({}, {}) on ({}, {})", left, right, this);
                if (this.empty)return false;
                if (this.covered)return true;
                if (left<=this.left&&right>=this.right) {
                    return this.covered;
                }
                boolean ans=true;
                if (left<=mid)ans&=this.lc.query(left, right);
                if (right>mid)ans&=this.rc.query(left, right);
                return ans;
            }
            void pushdown(){
                if (this.lc==null){
                    this.lc=new SegNode(left, mid);
                    this.lc.covered=this.covered;
                    this.lc.empty=this.empty;
                    this.rc=new SegNode(mid+1,right);
                    this.rc.covered=this.covered;
                    this.rc.empty=this.empty;
                    this.modified=false;
                } else if (modified){
                    this.lc.covered=this.covered;
                    this.lc.empty=this.empty;
                    this.lc.modified=true;
                    this.rc.covered=this.covered;
                    this.rc.empty=this.empty;
                    this.rc.modified=true;
                    this.modified=false;
                }
            }

//            @Override
//            public String toString() {
//                return MoreObjects.toStringHelper(this)
//                        .add("left", left)
//                        .add("right", right)
//                        .add("mid", mid)
//                        .add("modified", modified)
//                        .add("covered", covered)
//                        .add("empty", empty)
//                        .toString();
//            }
        }
        SegNode root;
        public RangeModule() {
            root =new SegNode(1, 1_000_000_000);

        }

        public void addRange(int left, int right) {
            root.addRange(left, right-1);

        }

        public boolean queryRange(int left, int right) {
            return root.query(left, right-1);

        }

        public void removeRange(int left, int right) {
            root.removeRange(left, right-1);

        }
    }


/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */