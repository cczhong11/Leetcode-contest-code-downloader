from collections import defaultdict
class Excel(object):

    def __init__(self, H,W):
        """
        :type H: int
        :type W: str
        """
        self.cols = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        self.col_dict = {c:idx for idx, c in enumerate(self.cols)}
        col_number = self.col_dict[W] + 1
        # to be simple we have a row 0 not used
        self.data = [[0 for _ in range(col_number)] for _ in range(H+1)]
        
        # we just stores which cell are sumed in which cell, so that if the value of that cell changes, we updated all the other cells
        self.sum_dict = defaultdict(lambda : defaultdict(int))
        self.sum_set = set() # the cell that is currently a sum value

    def set(self, r, c, v):
        """
        :type r: int
        :type c: str
        :type v: int
        :rtype: void
        """
        # might be sum of others, and might affect others too
        
        # if (r, c) not in self.sum_set:
        #     self.data[r][self.col_dict[c]] = v
        # else:
        oldv = self.get(r, c)
        diff = v - oldv
        
        if diff != 0:
            self.update(r, c, diff)
        self.remove_sum(r, c)

    
    def update(self, r, c, diff):
        self.data[r][self.col_dict[c]] += diff
        
        for (nr, nc), count in self.sum_dict[(r, c)].iteritems():
            self.update(nr, nc, diff * count)
        
    
    def get(self, r, c):
        """
        :type r: int
        :type c: str
        :rtype: int
        """
        return self.data[r][self.col_dict[c]]
        

    def sum(self, r, c, strs):
        """
        :type r: int
        :type c: str
        :type strs: List[str]
        :rtype: int
        """
        self.remove_sum(r, c)
        v = 0
        
        self.sum_set.add((r, c))
        for s in strs:
            if ':' not in s:
                col = s[0]
                row = int(s[1:])
                self.sum_dict[(row, col)][(r, c)] += 1
                v += self.get(row, col)
            else:
                info = s.split(':')
                
                start_col = self.col_dict[info[0][0]]
                start_row = int(info[0][1:])
                
                end_col = self.col_dict[info[1][0]]
                end_row = int(info[1][1:])
                
                for row in range(start_row, end_row+1):
                    for col in self.cols[start_col:end_col+1]:
                        self.sum_dict[(row, col)][(r, c)] += 1
                        v += self.get(row, col)
        self.data[r][self.col_dict[c]] = v
        
        return v
        
        
    def remove_sum(self, r, c):
        if (r, c) in self.sum_set:
            self.sum_set.remove((r, c))
            
        for k, dic in self.sum_dict.iteritems():
            if (r, c) in dic:
                del dic[(r, c)]
    
        # self.data[r][self.col_dict[c]] = 0
        


# Your Excel object will be instantiated and called as such:
# obj = Excel(H, W)
# obj.set(r,c,v)
# param_2 = obj.get(r,c)
# param_3 = obj.sum(r,c,strs)