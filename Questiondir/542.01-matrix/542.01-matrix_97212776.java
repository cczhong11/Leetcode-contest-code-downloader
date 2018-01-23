public class Solution {
    
    int m;
    int n;
    
    class Cord{
        
        int i;
        int j;
        
        public Cord(int i, int j){
            this.i = i;
            this.j = j;
        }
        
        public int hashCode(){
            return i * 17 + j;
        }
        
        public boolean equals(Object o){
            if(o instanceof Cord){
                Cord n = (Cord)o;
                return n.i == i && n.j == j;
            }else{
                return false;
            }
        }
        
    }
    
    Queue<Cord> q;
    Set<Cord> s;
    
    
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
            if(null == matrix)
                return null;
            
            m = matrix.size();
            if(0 == m)
                return matrix;
            n = matrix.get(0).size();
            if(0 == n)
                return matrix;
                
            q = new LinkedList<Cord>();
            s = new HashSet<>();
            
            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j){
                    if(0 == matrix.get(i).get(j)){
                        Cord c = new Cord(i, j);
                        q.add(c);
                        s.add(c);
                    }
                }
            }
            
            int dist = 0;
            
            while(!q.isEmpty()){
                
                Queue<Cord> nq = new LinkedList<>();
                
                while(!q.isEmpty()){

                    Cord c = q.poll();
                
                    int i = c.i;
                    int j = c.j;
                
                    if(i > 0){
                        Cord nc = new Cord(i-1, j);
                        if(!s.contains(nc)){
                            if(matrix.get(i-1).get(j) != 0){
                                matrix.get(i-1).set(j, dist+1);
                                nq.add(nc);
                                s.add(nc);
                            }
                        }
                    }
                
                    if(j > 0){
                        Cord nc = new Cord(i, j-1);
                        if(!s.contains(nc)){
                            if(matrix.get(i).get(j-1) != 0){
                                matrix.get(i).set(j-1, dist+1);
                                nq.add(nc);
                                s.add(nc);
                            }
                        }
                    }
                
                    if(i < m-1){
                        Cord nc = new Cord(i+1, j);
                        if(!s.contains(nc)){
                            if(matrix.get(i+1).get(j) != 0){
                                matrix.get(i+1).set(j, dist+1);
                                nq.add(nc);
                                s.add(nc);
                            }
                        }
                    }
                
                    if(j < n-1){
                        Cord nc = new Cord(i, j+1);
                        if(!s.contains(nc)){
                            if(matrix.get(i).get(j+1) != 0){
                                matrix.get(i).set(j+1, dist+1);
                                nq.add(nc);
                                s.add(nc);
                            }
                        }
                    }
                }
                dist++;
                q = nq;
                
            }
           
           return matrix;     
    }
}