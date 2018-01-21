class MyCalendarTwo(object):

    def __init__(self):
        self.ints = []
        self.doubles = []

    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        for d in self.doubles:
            if d[1] > start and d[0] < end:
                return False
        #update doubles:
        for i in self.ints:
            if i[1] > start and i[0] < end:
                self.doubles.append([max([i[0], start]),min([i[1],end])])
        self.ints.append([start,end])
        return True

# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)