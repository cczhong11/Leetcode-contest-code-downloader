class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        visited = set()
        n = len(image)
        m = len(image[0])
        color = image[sr][sc]
        
        def dfs(r, c):
            image[r][c] = newColor
            visited.add((r, c))
            for dr, dc in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                x, y = r+dr, c+dc
                if x < 0 or y < 0 or x >= n or y >= m or image[x][y] != color:
                    continue
                if (x, y) in visited:
                    continue
                dfs(x, y)
        
        dfs(sr, sc)
        return image
        