class grid(object):
    def __init__(self):
        self.isFormula = False
        self.val = 0
        self.formula = None

class Excel(object):

    def __init__(self, H,W):
        """
        :type H: int
        :type W: str
        """
        ord_w = ord(W) - 65
        size_width = ord_w + 1
        
        self.width = size_width
        self.height = H
        self.excel = []
        for times in xrange(0, H):
            lis = [grid() for width in xrange(0, size_width)]
            self.excel.append(lis)
        
    def indexConvertion(self, char):
        return ord(char) - 65

    def set(self, r, c, v):
        """
        :type r: int
        :type c: str
        :type v: int
        :rtype: void
        """
        col_index = self.indexConvertion(c)
        retrieve_grid = self.excel[r - 1][col_index]
        retrieve_grid.isFormula = False
        retrieve_grid.val = v
        retrieve_grid.formula = None

    def readchar(self, char):
        first_char = char[0]
        rest_char = char[1:]
        
        r = int(rest_char)
        c = first_char
        return (r, c)
        
        
    def get(self, r, c):
        """
        :type r: int
        :type c: str
        :rtype: int
        """
        row_index = r - 1
        col_index = self.indexConvertion(c)
        retrieve_grid = self.excel[row_index][col_index]
        
        if retrieve_grid.isFormula:
            formula = retrieve_grid.formula
            sum_up = 0
            for formu in formula:
                if ":" not in formu:
                    this_loc = self.readchar(formu)
                    sum_up += self.get(this_loc[0], this_loc[1])
                    
                else:
                    left_ran, right_ran = formu.split(":")
                    left_ran_loc = self.readchar(left_ran)
                    right_ran_loc = self.readchar(right_ran)
                    col_left = ord(left_ran_loc[1])
                    col_right = ord(right_ran_loc[1])
                    
                    for row in xrange(left_ran_loc[0], right_ran_loc[0] + 1):
                        for col in xrange(col_left, col_right + 1):
                            col_up = chr(col)
                            sum_up += self.get(row, col_up)
                            
            return sum_up
        else:
            return retrieve_grid.val
            
    def sum(self, r, c, strs):
        """
        :type r: int
        :type c: str
        :type strs: List[str]
        :rtype: int
        """
        row_index = r - 1
        col_index = self.indexConvertion(c)
        retrieve_grid = self.excel[row_index][col_index]
        
        retrieve_grid.isFormula = True
        retrieve_grid.formula = strs
        return self.get(r, c)
        


# Your Excel object will be instantiated and called as such:
# obj = Excel(H, W)
# obj.set(r,c,v)
# param_2 = obj.get(r,c)
# param_3 = obj.sum(r,c,strs)