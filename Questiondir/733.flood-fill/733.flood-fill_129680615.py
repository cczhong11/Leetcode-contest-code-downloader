class Solution:
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        ds = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        q = [(sr, sc)]
        oldColor = image[sr][sc]
        if oldColor == newColor:
            return image
        while len(q) > 0:
            sr, sc = q.pop()
            for d in ds:
                x, y = d
                if sr + x < 0 or sr + x >= len(image) or sc + y < 0 or sc + y >= len(image[0]) or image[sr + x][sc + y] != oldColor:
                    continue
                else:
                    q.append((sr + x, sc + y))
                    image[sr + x][sc + y] = -1
            image[sr][sc] = newColor
        return image