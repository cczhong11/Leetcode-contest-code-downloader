class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if newColor == image[sr][sc]:
            return image
        oldColor = image[sr][sc]
        stk = [(sr, sc)]
        n, m = len(image), len(image[0])
        while stk:
            cr, cc = stk.pop()
            image[cr][cc] = newColor
            for nr, nc in [(cr + 1, cc), (cr - 1, cc), (cr, cc + 1), (cr, cc - 1)]:
                if 0 <= nr < n and 0 <= nc < m and image[nr][nc] == oldColor:
                    stk.append((nr, nc))
        return image
