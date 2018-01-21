class MapSum(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.mp = collections.defaultdict(int)
        self.words = {}

    def insert(self, key, val):
        """
        :type key: str
        :type val: int
        :rtype: void
        """
        if key in self.words:
            diff = -self.words[key]
            self.words[key] = val
            val += diff
        else:
            self.words[key] = val
        n = len(key)
        for i in xrange(1, n + 1):
            self.mp[key[:i]] += val
        
    def sum(self, prefix):
        """
        :type prefix: str
        :rtype: int
        """
        if prefix in self.mp:
            return self.mp[prefix]
        return 0


# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)