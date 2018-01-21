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
        TreeMap<Integer,Interval> startTimes = new TreeMap<>();
        for(List<Interval> Emp : avails)
        {
            for(Interval conf : Emp)
            {
                if(!startTimes.containsKey(conf.start))
                {
                    startTimes.put(conf.start,conf);
                }else{
                    int e = startTimes.get(conf.start).end;
                    if(e< conf.end)
                        startTimes.put(conf.start,conf);
                }
            }
        }
        List<Interval> output = new ArrayList<>();
        int endtime = startTimes.get(startTimes.firstKey()).end;
        startTimes.remove(startTimes.firstKey());
        for(Integer s : startTimes.navigableKeySet())
        {
            Interval c = startTimes.get(s);
            if(c.start > endtime)
            {
                output.add(new Interval(endtime,c.start));
            }
            endtime = Math.max(endtime,c.end);
        }
        return output;
    }
    
}