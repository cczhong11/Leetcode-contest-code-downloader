/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> res=new ArrayList<Interval>();
        // 0-row,1-col,2-start,3-end;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] i1,int[] i2){
                return i1[2]-i2[2];
            }
        });
        for(int i=0;i<avails.size();i++){
            if(avails.get(i).size()>0){
                Interval curr=avails.get(i).get(0);
                pq.offer(new int[]{i,0,curr.start,curr.end});
            }
        }
        while(!pq.isEmpty()){
            int[] top=pq.poll();
            int end=top[3];
            top[1]++;
            if(avails.get(top[0]).size()>top[1]){
                Interval curr=avails.get(top[0]).get(top[1]);
                top[2]=curr.start;
                top[3]=curr.end;
                pq.offer(top);
            }
            while(!pq.isEmpty()&&end>=pq.peek()[2]){
                top=pq.poll();
                end=Math.max(end,top[3]);
                top[1]++;
                if(avails.get(top[0]).size()>top[1]){
                    Interval curr=avails.get(top[0]).get(top[1]);
                    top[2]=curr.start;
                    top[3]=curr.end;
                    pq.offer(top);
                }
            }
            if(!pq.isEmpty()){
                res.add(new Interval(end,pq.peek()[2]));
            }
        }
        return res;
    }
}