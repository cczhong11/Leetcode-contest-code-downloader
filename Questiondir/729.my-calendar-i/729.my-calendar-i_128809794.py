class MyCalendar:

    def __init__(self):
        self.events=[]

    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        if end<start:
            return False
        if all(start>=e or s>=end for s,e in self.events):
            self.events.append((start,end))
            return True
        return False


# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)