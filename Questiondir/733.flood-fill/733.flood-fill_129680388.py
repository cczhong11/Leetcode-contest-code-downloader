class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        self.image = image
        self.ni, self.nj = len(self.image), len(self.image[0])
        oldC = self.image[sr][sc]
        if oldC == newColor:
            return image
        
        self.fill(sr, sc, newColor, oldC)
        return self.image
        
        
    def fill(self, i, j, newC, oldC):
        if (0<= i < self.ni) and (0<= j < self.nj):
            
            if self.image[i][j] != oldC:
                return

            self.image[i][j] = newC
            self.fill(i-1, j, newC, oldC)
            self.fill(i+1, j, newC, oldC)
            self.fill(i, j-1, newC, oldC)
            self.fill(i, j+1, newC, oldC)
        