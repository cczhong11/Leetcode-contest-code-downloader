class MyCalendarTwo(object):

    def __init__(self):
    
        

        self.events = []
        self.twice = []

    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        for a, b in self.twice:
            if start < b and a < end:
                return False
        for a, b in self.events:
            if start >= b or a >= end:
                continue
            self.twice.append((max(a, start), min(b, end)))
        self.events.append((start, end))
        return True
# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)