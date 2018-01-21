import sys
from bisect import bisect_left

class MyCalendarTwo:

    def __init__(self):
        self.intervals = []
        self.counts = [0]
        self.endpoints = [-sys.maxsize, sys.maxsize]
        
    def new_endpoint(self, e):
        idx = bisect_left(self.endpoints, e)
        if self.endpoints[idx] != e:
            self.endpoints.insert(idx, e)
            self.counts.insert(idx, self.counts[idx-1])


    def book(self, start, end):
        """
        :type start: int
        :type end: int
        :rtype: bool
        """
        if start >= end:
            return True
        # Add new endpoints
        self.new_endpoint(start)
        self.new_endpoint(end)            
        # Check for new interval
        start_idx = bisect_left(self.endpoints, start)
        assert self.endpoints[start_idx] == start
        end_idx = bisect_left(self.endpoints, end)
        assert self.endpoints[end_idx] == end
        for idx in range(start_idx, end_idx):
            if self.counts[idx] >= 2:
                return False
        # Accept new interval
        for idx in range(start_idx, end_idx):
            self.counts[idx] += 1
        self.intervals.append((start, end))
        return True
        


# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)