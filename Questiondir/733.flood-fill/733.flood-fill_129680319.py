class Solution:
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if image[sr][sc] == newColor:
            return image
        rn, cn = len(image), len(image[0])
        oldColor = image[sr][sc]
        
        def dfs(x,y):
            if 0 <= x < rn and 0 <= y < cn and image[x][y] == oldColor:
                image[x][y] = newColor
                dfs(x-1,y)
                dfs(x+1,y)
                dfs(x,y+1)
                dfs(x,y-1)
        dfs(sr,sc)
        return image