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
        org_color = image[sr][sc]
        image[sr][sc] = newColor
        offsets = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        for offset in offsets:
            r = sr + offset[0]
            c = sc + offset[1]
            if r >= 0 and c >= 0 and r < len(image) and c < len(image[0]) and image[r][c] == org_color:
                self.floodFill(image, r, c, newColor)
        return image