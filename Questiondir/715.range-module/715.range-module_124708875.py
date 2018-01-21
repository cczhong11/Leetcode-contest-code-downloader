import bisect

class RangeModule(object):

    def __init__(self):
        self.ranges=[]
        

    def addRange(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: void
        """
        
        #print self.ranges,left,right
        
        if len(self.ranges)==0:
            self.ranges=[left,right]
        else:
            lefti=bisect.bisect_left(self.ranges,left)
            righti=bisect.bisect_right(self.ranges,right)
            
            
            if lefti%2==0:
                if lefti==len(self.ranges):
                    self.ranges.append(left)
                    self.ranges.append(right)
                else:
                    if righti==0:
                        self.ranges=[left,right]+self.ranges
                    else:
                        if righti%2==0:
                            self.ranges=self.ranges[:lefti]+[left,right]+self.ranges[righti:]
                        else:
                            self.ranges=self.ranges[:lefti]+[left]+self.ranges[righti:]
            else:
                
                if lefti==righti and lefti<len(self.ranges):
                    return
                
                if righti%2==0:
                    self.ranges=self.ranges[:lefti]+[right]+self.ranges[righti:]
                else:
                    self.ranges=self.ranges[:lefti]+self.ranges[righti:]
                
        
    def queryRange(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: bool
        """
        #print "query",self.ranges,left,right
        
        if len(self.ranges)==0:
            return False
        
        lefti=bisect.bisect_right(self.ranges,left)
        righti=bisect.bisect_left(self.ranges,right)
        
        return lefti==righti and lefti%2==1
        
        

    def removeRange(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: void
        """
        #print "remove",self.ranges,left,right
        
        if len(self.ranges)>0:
            lefti=bisect.bisect_left(self.ranges,left)
            righti=bisect.bisect_right(self.ranges,right)
            
            if lefti%2==0:
                if lefti==len(self.ranges):
                    return
                else:
                    if righti==0:
                        return
                    else:
                        if righti%2==0:
                            self.ranges=self.ranges[:lefti]+self.ranges[righti:]
                        else:
                            self.ranges=self.ranges[:lefti]+[right]+self.ranges[righti:]
            else:
                if righti%2==0:
                    self.ranges=self.ranges[:lefti]+[left]+self.ranges[righti:]
                else:
                    self.ranges=self.ranges[:lefti]+[left,right]+self.ranges[righti:]
        return
        
        


# Your RangeModule object will be instantiated and called as such:
# obj = RangeModule()
# obj.addRange(left,right)
# param_2 = obj.queryRange(left,right)
# obj.removeRange(left,right)