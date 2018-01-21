class MyCalendarTwo:
    def __init__(self):
        self.bookings = []
        self.doubles = []

    def book(self, start, end):
        # print(self.doubles)
        for s, e in self.doubles:
            if e > start and s < end:
                return False
        for s, e in self.bookings:
            if e > start and s < end:
                self.doubles.append([max(min(end, s), start), min(max(start, e), end)])
        self.bookings.append([start, end])
        return True



# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)