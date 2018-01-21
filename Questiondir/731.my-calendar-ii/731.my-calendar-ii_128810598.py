class MyCalendarTwo(object):

    def __init__(self):
        self.bList = []

    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        tList = []
        for s, e in self.bList:
            if e<=start or end<=s:
                continue
            ns = s if s > start else start
            ne = e if e < end else end
            fail = False
            for ts, te in tList:
                if not (te<=ns or ne<=ts):
                    fail = True
                    break
            if fail:
                return False
            tList.append((ns, ne))
        self.bList.append((start, end))
        return True
        


# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)