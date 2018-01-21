import bisect
class MyCalendar(object):

    def __init__(self):
        self.cal = []
        

    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        for a, b in self.cal:
            if a <= start < b or start <= a < end:
                return False
        self.cal.append((start,end))
        return True
        
