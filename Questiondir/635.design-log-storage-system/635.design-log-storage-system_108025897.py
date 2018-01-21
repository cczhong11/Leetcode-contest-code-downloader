class LogSystem(object):

    def __init__(self):
        self.arr = []
        self.SS = ["2000", "01", "01", "00", "00", "00"]
        self.EE = ["2017", "12", "31", "23", "59", "59"]
        self.Index = {"Year":0, "Month":1, "Day":2, "Hour":3, "Minute":4, "Second":5}
    def put(self, id, timestamp):
        """
        :type id: int
        :type timestamp: str
        :rtype: void
        """
        self.arr.append((id, timestamp))
        

    def retrieve(self, s, e, gra):
        """
        :type s: str
        :type e: str
        :type gra: str
        :rtype: List[int]
        """
        start = s.split(':')
        end = e.split(':')
        if gra in self.Index:
            idx = self.Index[gra] + 1
            s = ":".join([":".join(start[:(idx)]), ":".join(self.SS[idx:])]).rstrip(':')
            e = ":".join([":".join(end[:(idx)]), ":".join(self.EE[idx:])]).rstrip(':')
        result = []
        for id,a in self.arr:
            if s <= a <= e:
                result.append(id)
        return result


# Your LogSystem object will be instantiated and called as such:
# obj = LogSystem()
# obj.put(id,timestamp)
# param_2 = obj.retrieve(s,e,gra)