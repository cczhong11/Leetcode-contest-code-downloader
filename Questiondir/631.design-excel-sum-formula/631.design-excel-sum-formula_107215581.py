class Excel(object):

    def __init__(self, H,W):
        """
        :type H: int
        :type W: str
        """
        self.sheet = []
        self.height = H
        self.width = ord(W) - ord('A') + 1
        for i in range(H):
            rows = []
            for j in range(self.width):
                rows.append(0)
            self.sheet.append(rows)
        self.addUpdate = {} #key: dest, val: list_of_strs

    def set(self, r, c, v):
        """
        :type r: int
        :type c: str
        :type v: int
        :rtype: void
        """
        row = r-1
        col = ord(c) - ord('A')
        self.sheet[row][col] = v
        
        key = (r, c)    
        if key in self.addUpdate.keys():
            del self.addUpdate[key]
        
        for l in range(2):
            for k, v in self.addUpdate.items():
                r, c = k
                crow = r - 1
                ccol = ord(c) - ord('A')
                self.sheet[crow][ccol] = self.sum(r, c, v)

    def get(self, r, c):
        """
        :type r: int
        :type c: str
        :rtype: int
        """
        row = r-1
        col = ord(c) - ord('A')
        return self.sheet[row][col]

    def sum(self, r, c, strs):
        """
        :type r: int
        :type c: str
        :type strs: List[str]
        :rtype: int
        """
        row = r-1
        col = ord(c) - ord('A')
        total = 0
        #print(total)
        for word in strs:
            currWord = word
            if len(currWord) == 2:
                crow = int(currWord[1]) - 1
                ccol = ord(currWord[0]) - ord('A')
                total += self.sheet[crow][ccol]
            else:
                currWord = currWord.split(':')
                startRow = int(currWord[0][1:]) - 1
                startCol = ord(currWord[0][0]) - ord('A')
                endRow = int(currWord[1][1:]) - 1
                endCol = ord(currWord[1][0]) - ord('A')
                #print(startRow, startCol, endRow, endCol)
                for i in range(startRow, endRow + 1, 1):
                    for j in range(startCol, endCol + 1, 1):
                        total += self.sheet[i][j]
                #print(total)
        key = (r, c)
        val = strs
        self.addUpdate[key] = val
        self.sheet[row][col] = total
                        
        return total


# Your Excel object will be instantiated and called as such:
# obj = Excel(H, W)
# obj.set(r,c,v)
# param_2 = obj.get(r,c)
# param_3 = obj.sum(r,c,strs)