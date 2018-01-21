class Solution {
    public String countOfAtoms(String formula) {
        TreeMap<String,Integer> map=new TreeMap<String,Integer>();
        Stack<TreeMap<String,Integer>> stack=new Stack<TreeMap<String,Integer>>();;
        Stack<Integer> mapCount=new Stack<Integer>();
        String ele="";
        int index=0;
        while(index<formula.length()){
            int start=index;
            char ch=formula.charAt(index);
            if(ch>='A'&&ch<='Z'){
                index++;
                while(index<formula.length()&&formula.charAt(index)>='a'&&formula.charAt(index)<='z'){
                    index++;
                }
                ele=formula.substring(start,index);
                if(index==formula.length()||!(formula.charAt(index)>='0'&&formula.charAt(index)<='9')){
                    if(!map.containsKey(ele)){
                        map.put(ele,0);
                    }
                    map.put(ele,map.get(ele)+1);
                }
            }
            else if(ch>='0'&&ch<='9'){
                index++;
                while(index<formula.length()&&formula.charAt(index)>='0'&&formula.charAt(index)<='9'){
                    index++;
                }
                int count=Integer.parseInt(formula.substring(start,index));
                if(start-1>=0&&formula.charAt(start-1)==')'){
                    for(String key:map.keySet()){
                        map.put(key,map.get(key)*count);
                    }
                    TreeMap<String,Integer> lastMap=map;
                    map=stack.pop();
                    mergeMap(map,lastMap);
                }
                else{
                    if(!map.containsKey(ele)){
                        map.put(ele,0);
                    }
                    map.put(ele,map.get(ele)+count);
                }
            }
            else if(ch=='('){
                stack.push(map);
                map=new TreeMap<String,Integer>();
                index++;
            }
            else{
                index++;
                if(index==formula.length()||!(formula.charAt(index)>='0'&&formula.charAt(index)<='9')){
                    TreeMap<String,Integer> lastMap=map;
                    map=stack.pop();
                    mergeMap(map,lastMap);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String key:map.keySet()){
            sb.append(key);
            if(map.get(key)>1){
                sb.append(map.get(key));
            }
        }
        return sb.toString();
    }
    public void mergeMap(TreeMap<String,Integer> map1,TreeMap<String,Integer> map2){
        for(String key2:map2.keySet()){
            if(!map1.containsKey(key2)){
                map1.put(key2,0);
            }
            map1.put(key2,map1.get(key2)+map2.get(key2));
        }
    }
}