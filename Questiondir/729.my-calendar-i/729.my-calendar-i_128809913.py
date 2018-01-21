class MyCalendar(object):

    def __init__(self):
        self.bookings = []
        

    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        for b in self.bookings:
            if end > b[0] and start < b[1]:
                return False
        self.bookings.append([start,end])
        return True
        


# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)