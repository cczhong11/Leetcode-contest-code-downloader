class MapSum(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.d = {}
        

    def insert(self, key, val):
        """
        :type key: str
        :type val: int
        :rtype: void
        """
        self.d[key] = val
        

    def sum(self, prefix):
        """
        :type prefix: str
        :rtype: int
        """
        return sum([self.d[i] for i in self.d if i .startswith(prefix)] or [0])
        


# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)