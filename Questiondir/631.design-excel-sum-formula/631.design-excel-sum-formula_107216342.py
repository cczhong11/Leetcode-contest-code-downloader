class Excel(object):

    def __init__(self, H,W):
        """
        :type H: int
        :type W: str
        """
        self.form = {}
        
        for col in range(ord('A'), ord(W)+1):
            self.form[chr(col)] = [0] * H
        
    def set(self, r, c, v):
        """
        :type r: int
        :type c: str
        :type v: int
        :rtype: void
        """
        self.form[c][r-1] = v

    def get(self, r, c):
        """
        :type r: int
        :type c: str
        :rtype: int
        """
        obj = self.form[c][r-1]
        if isinstance(obj, int): return obj
        #print(self.form)
        return obj()

    def sum(self, r, c, strs):
        """
        :type r: int
        :type c: str
        :type strs: List[str]
        :rtype: int
        """
        
        #print(self.form)
        self.form[c][r-1] = self._sum(strs)
        return self.get(r, c)
        
    def _sum(self, strs):
        
        sum_list = []
        for item in strs:
            _st = tuple(item.split(":"))
            #print(_st)
            if len(_st) > 1:
                s, e = self._sepstr(_st[0]), self._sepstr(_st[1])
            else:
                s = e = self._sepstr(_st[0])
            for r in range(s[0], e[0]+1):
                for c in range(s[1], e[1]+1):
                    sum_list.append((chr(r),c))
        return lambda : sum([self.get(c+1, r) for r, c in sum_list])
                
            
    def _sepstr(self, s):
        index = 0
        while not s[index].isdigit(): index += 1
        #print(s[:index], s[index:])
        return (ord(s[:index]), int(s[index:])-1)
        

# Your Excel object will be instantiated and called as such:
# obj = Excel(H, W)
# obj.set(r,c,v)
# param_2 = obj.get(r,c)
# param_3 = obj.sum(r,c,strs)