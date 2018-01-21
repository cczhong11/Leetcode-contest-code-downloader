class Solution:
    def rec(self, image, r, c, NC, OC, d):
        if (r, c) in d:
            return
        
        image[r][c] = NC
        d.add((r, c))
        
        for di in range(-1, 2):
            for dj in range(-1, 2):
                if abs(di) + abs(dj) == 1:
                    if r + di < len(image) and c + dj < len(image[0]) and r + di >= 0 and c + dj >= 0:
                        if image[r + di][c + dj] == OC:
                            self.rec(image, r + di, c + dj, NC, OC, d)
    
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        
        d = set()
        
        self.rec(image, sr, sc, newColor, image[sr][sc], d)
            
        return image