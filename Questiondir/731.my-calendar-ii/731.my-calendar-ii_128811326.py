class MyCalendarTwo(object):

    def __init__(self):
    	self.intervals = []
    	self.conflicts = []
        
    def book(self, start, end):
    	for left, right in self.conflicts:
    		if not (end <= left or start >= right):
    			return False

    	for left, right in self.intervals:
    		l, r = max(start, left), min(end, right)
    		if l < r:
    			self.conflicts.append([l, r])

    	self.intervals.append([start, end])
    	return True
        


# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)