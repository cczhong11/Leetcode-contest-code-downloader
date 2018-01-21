class Solution:
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        oldC = image[sr][sc]
        def dfs(r, c):
            nonlocal image
            if r < 0 or r >= len(image) or c < 0 or c >= len(image[0]) or image[r][c] != oldC:
                return
            image[r][c] = newColor
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
        if oldC == newColor:
            return image
        dfs(sr, sc)
        return image