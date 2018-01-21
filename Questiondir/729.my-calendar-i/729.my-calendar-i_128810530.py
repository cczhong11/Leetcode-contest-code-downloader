class MyCalendar:

    def __init__(self):
        self.intervals = []

    @staticmethod
    def intersect(a, b, c, d):
        # [a, b], [c, d]
        return not (d < a or b < c)
        

    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        # [start, end) -> [start, end-1]
        end -= 1
        if start > end:
            return True
        for s, e in self.intervals:
            if self.intersect(s, e, start, end):
                return False
        self.intervals.append((start, end))
        return True
        


# Your MyCalendar object will be instantiated and called as such:
#obj = MyCalendar()
#print(obj.book(10, 20))
#print(obj.book(15, 25))
#print(obj.book(20, 30))