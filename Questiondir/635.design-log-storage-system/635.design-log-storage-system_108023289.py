from datetime import datetime
import calendar
class LogSystem(object):

    def __init__(self):
        self.d = {}
        

    def put(self, id, timestamp):
        """
        :type id: int
        :type timestamp: str
        :rtype: void
        """
        self.d[datetime.strptime(timestamp, '%Y:%m:%d:%H:%M:%S')] = id
        

    def retrieve(self, s, e, gra):
        """
        :type s: str
        :type e: str
        :type gra: str
        :rtype: List[int]
        """
        if gra == 'Year':
            s = s.split(':')[0] + ':01:01:00:00:00'
            e = e.split(':')[0] + ':12:31:23:59:59'
        elif gra == 'Month':
            s = ':'.join(s.split(':')[:2]) + ':01:00:00:00'
            e = ':'.join(e.split(':')[:2]) + ':' + str(calendar.monthrange(int(e.split(':')[0]), int(e.split(':')[1]))[1]) + ':23:59:59'
        elif gra == 'Day':
            s = ':'.join(s.split(':')[:3]) + ':00:00:00'
            e = ':'.join(e.split(':')[:3]) + ':23:59:59'
        elif gra == 'Hour':
            s = ':'.join(s.split(':')[:4]) + ':00:00'
            e = ':'.join(e.split(':')[:4]) + ':59:59'
        elif gra == 'Minute':
            s = ':'.join(s.split(':')[:5]) + ':00'
            e = ':'.join(e.split(':')[:5]) + ':59'
        s = datetime.strptime(s, '%Y:%m:%d:%H:%M:%S')
        e = datetime.strptime(e, '%Y:%m:%d:%H:%M:%S')
        ans = []
        for k,v in self.d.iteritems():
            if k >= s and k <= e:
                ans.append(v)
        return ans
        
            
        


# Your LogSystem object will be instantiated and called as such:
# obj = LogSystem()
# obj.put(id,timestamp)
# param_2 = obj.retrieve(s,e,gra)