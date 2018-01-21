class MyCalendar:

    def __init__(self):
        self.bookings = []

    def book(self, start, end):
        for s, e in self.bookings:
            if e > start and s < end:
                return False
        self.bookings.append((start, end))
        return True
    

# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)