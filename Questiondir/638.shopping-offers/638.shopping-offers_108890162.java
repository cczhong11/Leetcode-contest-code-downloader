public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if(needs.size()==0){
            return 0;
        }
        Map<String,Integer> map=new HashMap<String,Integer>();
        String s=serialize(needs);
        search(price,special,needs,0,map);
        return map.get(s);
    }
    public void search(List<Integer> price, List<List<Integer>> special,List<Integer> needs, int targetItem,Map<String,Integer> map){
        if(targetItem==needs.size()){
            String s=serialize(needs);
            map.put(s,0);
            return;
        }
        if(needs.get(targetItem)==0){
            search(price,special,needs,targetItem+1,map);
            return ;
        }
        String s=serialize(needs);
        List<Integer> newneeds=new ArrayList<Integer>(needs);
        newneeds.set(targetItem,0);
        String temp=serialize(newneeds);
        if(!map.containsKey(temp)){
            search(price,special,newneeds,targetItem,map);
        }
        int minCost=price.get(targetItem)*needs.get(targetItem)+map.get(temp);
        for(int i=0;i<special.size();i++){
            boolean cont=true;
            newneeds=new ArrayList<Integer>(needs);
            for(int j=0;j<needs.size()&&cont;j++){
                if(special.get(i).get(j)>newneeds.get(j)){
                    cont=false;
                }
                else{
                    newneeds.set(j,newneeds.get(j)-special.get(i).get(j));
                }
            }
            if(cont){
                temp=serialize(newneeds);
                if(!map.containsKey(temp)){
                    search(price,special,newneeds,targetItem,map);
                }
                minCost=Math.min(special.get(i).get(special.get(i).size()-1)+map.get(temp),minCost);
            }
        }
        map.put(s,minCost);
    }
    public String serialize(List<Integer> needs){
        StringBuilder sb=new StringBuilder();
        for(int num:needs){
            sb.append(num);
            sb.append(',');
        }
        return sb.toString();
    }
}