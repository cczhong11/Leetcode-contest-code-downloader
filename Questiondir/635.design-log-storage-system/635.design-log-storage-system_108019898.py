from collections import defaultdict

class LogSystem(object):

    def __init__(self):
        self.logs = defaultdict(list)

    def put(self, id, timestamp):
        """
        :type id: int
        :type timestamp: str
        :rtype: void
        """
        self.logs[timestamp].append(id)

    def retrieve(self, s, e, gra):
        """
        :type s: str
        :type e: str
        :type gra: str
        :rtype: List[int]
        """
        if gra == 'Year':
            s = s[:4] + ":00"*5
            e = e[:4] + ":99"*5
        elif gra == 'Month':
            s = s[:7] + ":00"*4
            e = e[:7] + ":99"*4
        elif gra == 'Day':
            s = s[:10] + ":00"*3
            e = e[:10] + ":99"*3
        elif gra == 'Hour':
            s = s[:13] + ":00"*2
            e = e[:13] + ":99"*2
        elif gra == 'Minute':
            s = s[:16] + ":00"
            e = e[:16] + ":99"
        return [ id for (k,v) in self.logs.iteritems() if s <= k <= e for id in v ]

# Your LogSystem object will be instantiated and called as such:
# obj = LogSystem()
# obj.put(id,timestamp)
# param_2 = obj.retrieve(s,e,gra)