import re
class MapSum(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dic = {}
        

    def insert(self, key, val):
        """
        :type key: str
        :type val: int
        :rtype: void
        """
        self.dic[key] = val
        #print(self.dic)
        

    def sum(self, prefix):
        """
        :type prefix: str
        :rtype: int
        """
        asum = 0
        for x in self.dic.keys():
            if re.search('^{}'.format(prefix),x):
                asum += self.dic[x]
        return asum
        
        
        
        


# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)