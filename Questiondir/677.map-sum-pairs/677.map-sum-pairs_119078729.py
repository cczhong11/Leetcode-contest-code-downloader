class Node(object):
    def __init__(self,val):
        self.next=[None]*26
        self.total=val

class MapSum(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head=Node(0)
        self.d={}
        
    def od(self,cha):
        return ord(cha)-ord('a')

    def insert(self, key, val):
        """
        :type key: str
        :type val: int
        :rtype: void
        """
        if key in self.d:
            t=self.d[key]
            self.d[key]=val
            val=val-t
        else:
            self.d[key]=val
        
        p=self.head
        p.total+=val
        
        for ch in key:
            if not p.next[self.od(ch)]:
                p.next[self.od(ch)]=Node(0)
            p=p.next[self.od(ch)]
            p.total+=val
            

    def sum(self, prefix):
        """
        :type prefix: str
        :rtype: int
        """
        p=self.head
        for ch in prefix:
            if not p.next[self.od(ch)]:
                return 0
            p=p.next[self.od(ch)]
        return p.total
            
            


# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)