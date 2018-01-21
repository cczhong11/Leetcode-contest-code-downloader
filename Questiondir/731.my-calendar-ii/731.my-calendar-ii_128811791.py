
class MyCalendarTwo(object):

    def __init__(self):
        self.cal = []
        self.dep = []
        

    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        dep = set(i for i, (a, b) in enumerate(self.cal) if (a <= start < b or start <= a < end))
        if any(len(self.dep[j] & dep) > 0 for j in dep):
            return False
        self.cal.append((start,end))
        self.dep.append(dep)
        return True

