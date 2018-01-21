class MyCalendar(object):

    def __init__(self):
    	self.intervals = []
        
    def book(self, start, end):
    	for interval in self.intervals:
    		if not (end <= interval[0] or start >= interval[1]):
    			return False
    	self.intervals.append([start, end])
    	return True
        


# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)