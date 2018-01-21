import datetime
import time

class LogSystem(object):

    def __init__(self):
        self.t = []

    def put(self, id, ts):
        """
        :type id: int
        :type timestamp: str
        :rtype: void
        """
        self.t.append((ts.split(':'), id))

    def retrieve(self, s, e, gra):
        """
        :type s: str
        :type e: str
        :type gra: str
        :rtype: List[int]
        """
        res = []
        zz = {}
        zz['Year'] = 0
        zz['Month'] = 1
        zz['Day'] = 2
        zz['Hour'] = 3
        zz['Minute'] = 4
        zz['Second'] = 5
        p = zz[gra]
        ss = int(''.join(s.split(':')[:p+1]))
        ee = int(''.join(e.split(':')[:p+1]))
        # print ss, ee
        for z in self.t:
            # print ''.join(z[0][:p+1]), z[1]
            if int(''.join(z[0][:p+1])) >= ss and int(''.join(z[0][:p+1])) <= ee:
                res.append(z[1])
        return res
        


# Your LogSystem object will be instantiated and called as such:
# obj = LogSystem()
# obj.put(id,timestamp)
# param_2 = obj.retrieve(s,e,gra)