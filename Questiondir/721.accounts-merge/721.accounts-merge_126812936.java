class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> owner=new HashMap<String,String>();
        Map<String,String> parent=new HashMap<String,String>();
        for(int i=0;i<accounts.size();i++){
            List<String> curr=accounts.get(i);
            String user=curr.get(0);
            for(int j=1;j<curr.size();j++){
                owner.put(curr.get(j),user);
                String email=curr.get(j);
                if(!parent.containsKey(email)){
                    parent.put(email,email);
                }
                if(j>1){
                    merge(parent,curr.get(1),curr.get(j));
                }
            }
        }
        Map<String,List<String>> lists=new HashMap<String,List<String>>();
        for(String c:parent.keySet()){
            String p=findParent(parent,c);
            if(!lists.containsKey(p)){
                lists.put(p,new ArrayList<String>());
            }
            lists.get(p).add(c);
        }
        List<List<String>> res=new ArrayList<List<String>>();
        for(String e:lists.keySet()){
            List<String> toadd=new ArrayList<String>();
            toadd.add(owner.get(e));
            List<String> temp=lists.get(e);
            Collections.sort(temp);
            toadd.addAll(temp);
            res.add(toadd);
        }
        return res;
    }
    public String findParent(Map<String,String> parent,String e){
        while(parent.get(e)!=e){
            e=parent.get(e);
        }
        return e;
    }
    public void merge(Map<String,String> parent,String e1,String e2){
        int d1=0;
        int d2=0;
        while(parent.get(e1)!=e1){
            e1=parent.get(e1);
            d1++;
        }
        while(parent.get(e2)!=e2){
            e2=parent.get(e2);
            d2++;
        }
        if(d1<d2){
            parent.put(e1,e2);
        }
        else{
            parent.put(e2,e1);
        }
    }
}