	class Solution {
	    public int openLock(String[] deadends, String target) {
	        int t = Integer.parseInt(target);
	        boolean[] de = new boolean[10000];
	        for(String d : deadends){
	        	de[Integer.parseInt(d)] = true;
	        }
	        if(de[0]){
	        	return -1;
	        }
	        Queue<Integer> q = new ArrayDeque<>();
	        q.add(0);
	        int[] ds = new int[10000];
	        Arrays.fill(ds, 99999999);
	        ds[0] = 0;
	        while(!q.isEmpty()){
	        	int cur = q.poll();
	        	for(int d = 1;d <= 1000;d*=10){
	        		int l = cur % (d*10) / d;
	        		{
	        			int ne = l == 0 ? cur + 9*d : cur - d;
	        			if(!de[ne] && ds[ne] > ds[cur] + 1){
	        				ds[ne] = ds[cur] + 1;
	        				q.add(ne);
	        			}
	        		}
	        		{
	        			int ne = l == 9 ? cur - 9*d : cur + d;
	        			if(!de[ne] && ds[ne] > ds[cur] + 1){
	        				ds[ne] = ds[cur] + 1;
	        				q.add(ne);
	        			}
	        		}
	        	}
	        }
	        if(ds[t] > 100000){
	        	return -1;
	        }else{
	        	return ds[t];
	        }
	    }
	}	
