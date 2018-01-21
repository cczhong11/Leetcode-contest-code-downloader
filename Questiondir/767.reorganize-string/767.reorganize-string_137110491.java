class Solution {
    public String reorganizeString(String S) {
        int[] count=new int[256];
        int max=0;
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            count[ch]++;
            max=Math.max(max,count[ch]);
        }
        if(max>S.length()-max+1){
            return "";
        }
        List<StringBuilder> list=new ArrayList<StringBuilder>();
        for(int i=0;i<max;i++){
            list.add(new StringBuilder());
        }
        //0count 1char
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] i1,int[] i2){
                return i2[0]-i1[0];
            }
        });
        for(int i=0;i<256;i++){
            if(count[i]>0){
                pq.offer(new int[]{count[i],i});
            }
        }
        int index=0;
        while(!pq.isEmpty()){
            int[] top=pq.poll();
            for(int i=0;i<top[0];i++){
                if(top[0]<max&&index==list.size()-1){
                    index=0;
                }
                list.get(index).append((char)top[1]);
                index=(index+1)%list.size();
            }
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<list.size();i++){
            res.append(list.get(i).toString());
        }
        return res.toString();
    }
}