class MyCalendarTwo:

    def __init__(self):
        self.events=[]
        self.double=[]

    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        if all(start>=e or s>=end for s,e in self.double):
            for s,e in self.events:
                if start<e and s<end:
                    self.double.append((max(start,s),min(end,e)))
            self.events.append((start,end))
            return True
        return False

# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)