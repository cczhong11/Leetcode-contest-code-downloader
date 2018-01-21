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
        List<Interval> a=new ArrayList<>();
        List<Interval> ans=new ArrayList<>();
        for (List<Interval> list:avails)
            for (Interval in:list)
                a.add(in);
        Collections.sort(a,(c,d)->(c.start-d.start));
        int min=a.get(0).start,max=a.get(0).end;
        for (int i=1;i<a.size();i++)
        {
            int l=a.get(i).start,r=a.get(i).end;
            if (r<=max) continue;
            if (l>max)
            {
                ans.add(new Interval(max,l));
                min=l;
                max=r;
            }
            else max=r;
        }
        return ans;
    }
}