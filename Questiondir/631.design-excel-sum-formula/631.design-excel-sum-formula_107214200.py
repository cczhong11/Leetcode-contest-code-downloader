class Excel(object):

    def __init__(self, H,W):
        """
        :type H: int
        :type W: str
        """
        import collections
        self.height = H + 1
        self.width = ord(W) - ord('A') + 1
        self.val = [[0] * self.width for x in xrange(self.height)]
        self.to_update = [[collections.defaultdict(int) for j in xrange(self.width)] for i in xrange(self.height)]
        
    def add(self, r, c, diff):
        self.val[r][ord(c) - ord('A')] += diff
        for rr, cc in self.to_update[r][ord(c) - ord('A')]:
            self.add(rr, cc, diff * self.to_update[r][ord(c) - ord('A')][(rr, cc)])
    
    def set(self, r, c, v):
        """
        :type r: int
        :type c: str
        :type v: int
        :rtype: void
        """
        for i in xrange(self.height):
            for j in xrange(self.width):
                #if r == 2 and c == "B":
                    #print i, j, (r,c), self.to_update[i][j]
                if (r,c) in self.to_update[i][j]:
                    del self.to_update[i][j][(r,c)]
        diff = v - self.get(r, c)
        self.add(r, c, diff)
        #print r, c, self.to_update
        

    def get(self, r, c):
        """
        :type r: int
        :type c: str
        :rtype: int
        """
        return self.val[r][ord(c) - ord('A')]
        

    def sum(self, r, c, strs):
        """
        :type r: int
        :type c: str
        :type strs: List[str]
        :rtype: int
        """
        s = 0
        for i in xrange(self.height):
            for j in xrange(self.width):
                if (r,c) in self.to_update[i][j]:
                    self.to_update[i][j][(r,c)] = 0
        for pos in strs:
            if ":" not in pos:
                rr = int(pos[1:])
                cc = pos[0]
                s += self.get(rr, cc)
                self.to_update[rr][ord(cc) - ord('A')][(r, c)] += 1
            else:
                start, end = pos.split(':')
                start_row_idx = int(start[1:])
                end_row_idx = int(end[1:])
                start_col_idx = ord(start[0]) - ord('A')
                end_col_idx = ord(end[0]) - ord('A')
                for row_idx in xrange(start_row_idx, end_row_idx+1):
                    for col_idx in xrange(start_col_idx, end_col_idx+1):
                        s += self.val[row_idx][col_idx]
                        self.to_update[row_idx][col_idx][(r, c)] += 1
        self.add(r, c, s - self.get(r, c))
        return s
        


# Your Excel object will be instantiated and called as such:
# obj = Excel(H, W)
# obj.set(r,c,v)
# param_2 = obj.get(r,c)
# param_3 = obj.sum(r,c,strs)