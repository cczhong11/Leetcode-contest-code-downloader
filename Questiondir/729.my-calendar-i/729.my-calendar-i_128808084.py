class MyCalendar(object):

    def __init__(self):
        self.bList = []

    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        for s, e in self.bList:
            if not (e<=start or end<=s):
                return False
        self.bList.append((start, end))
        return True
        


# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)