class LogSystem(object):

    def __init__(self):
        self.log = []
        

    def put(self, id, timestamp):
        """
        :type id: int
        :type timestamp: str
        :rtype: void
        """
        self.log.append((id, timestamp))

    def retrieve(self, s, e, gra):
        """
        :type s: str
        :type e: str
        :type gra: str
        :rtype: List[int]
        """
        if gra == 'Year':
            l = 4
        if gra == 'Month':
            l = 7
        if gra == 'Day':
            l = 10
        if gra == 'Hour':
            l = 13
        if gra == 'Minute':
            l = 16
        if gra == 'Second':
            l = 19
        s = s[:l]
        e = e[:l] + ';'
        res = []
        for id, ts in self.log:
            if s <= ts <= e:
                res.append(id)
        return res