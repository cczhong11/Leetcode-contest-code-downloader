class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        seen = set()
        color = image[sr][sc]
        n, m = len(image), len(image[0])
        directions = [[-1,0],[1,0],[0,-1],[0,1]]
        def dfs(x,y):
            if (x,y) not in seen:
                seen.add((x,y))
                image[x][y] = newColor
                for d in directions:
                    if 0 <= x + d[0] < n and 0 <= y + d[1] < m and image[x+d[0]][y+d[1]] == color and (x+d[0], y+d[1]) not in seen:
                        dfs(x+d[0], y+d[1])
        dfs(sr,sc)
        return image
        