class MyCalendar(object):


        
    def __init__(self):
        self.events = []

    def book(self, start, end):
        for a, b in self.events:
            if start < b and a < end:
                return False
        self.events.append((start, end))
        return True


# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)