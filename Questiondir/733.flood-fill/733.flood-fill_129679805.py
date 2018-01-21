class Solution(object):
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
        dirList = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        nr = len(image)
        nc = len(image[0])
        def dfs(x, y):
            curColor = image[x][y]
            image[x][y] = newColor
            for dx, dy in dirList:
                newx = x + dx
                newy = y + dy
                if not (0<=newx<nr and 0<=newy<nc):
                    continue
                if image[newx][newy] == curColor:
                    dfs(newx, newy)
        dfs(sr, sc)
        return image
            