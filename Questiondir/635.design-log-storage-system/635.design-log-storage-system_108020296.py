class LogSystem(object):

    def __init__(self):
        self.logs = []
        

    def put(self, id, timestamp):
        """
        :type id: int
        :type timestamp: str
        :rtype: void
        """
        self.logs.append((id, timestamp))
        
        

    def retrieve(self, s, e, gra):
        """
        :type s: str
        :type e: str
        :type gra: str
        :rtype: List[int]
        """
        grans = ['Year','Month','Day','Hour','Minute','Second']
        mx = ['9999','12','31','23','59','59']
        mn = ['0000','01','01','00','00','00']
        g = [i for i in xrange(len(grans)) if grans[i] == gra][0]
        ssp = s.split(':')
        esp = e.split(':')
        for i in xrange(g+1, len(grans)):
            ssp[i] = mn[i]
            esp[i] = mx[i]
        s = ':'.join(ssp)
        e = ':'.join(esp)
        res = []
        for id, ts in self.logs:
            if ts >= s and ts <= e:
                res.append(id)
        return res


# Your LogSystem object will be instantiated and called as such:
# obj = LogSystem()
# obj.put(id,timestamp)
# param_2 = obj.retrieve(s,e,gra)