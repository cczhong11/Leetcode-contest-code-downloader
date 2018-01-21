class LogSystem(object):
    

    def __init__(self):
        self.dict = {'Year':0, 'Month': 1, 'Day': 2, 'Hour': 3, 'Minute': 4, 'Second':5}
        self.vals = {}

    def put(self, id, timestamp):
        """
        :type id: int
        :type timestamp: str
        :rtype: void
        """
        self.vals[id] = timestamp
        
    def change(self, s, gra):
        ss = s.split(':')
        g = self.dict[gra];
        for i in range(len(ss)):
            if i > g:
                ss[i] = '00'
                
        return ':'.join(ss)

    def retrieve(self, s, e, gra):
        """
        :type s: str
        :type e: str
        :type gra: str
        :rtype: List[int]
        """
        a = self.change(s, gra)
        b = self.change(e, gra)
                
        ret = []
        
        for key in self.vals:
            ch = self.change(self.vals[key], gra)
            if ch >= a and ch <= b:
                ret.append(key)
        return ret
                

# Your LogSystem object will be instantiated and called as such:
# obj = LogSystem()
# obj.put(id,timestamp)
# param_2 = obj.retrieve(s,e,gra)