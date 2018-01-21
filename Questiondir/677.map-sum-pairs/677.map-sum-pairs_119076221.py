class MapSum(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dict = {}
        

    def insert(self, key, val):
        """
        :type key: str
        :type val: int
        :rtype: void
        """
        self.dict[key] = val
        

    def sum(self, prefix):
        """
        :type prefix: str
        :rtype: int
        """
        result = 0
        for key in self.dict:
            if key[:len(prefix)] == prefix:
                result += self.dict[key]
        return result


# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)