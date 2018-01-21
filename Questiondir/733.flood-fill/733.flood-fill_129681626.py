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
        m = len(image)
        n = len(image[0])
        stack = [(sr, sc)]
        toreplace = image[sr][sc]
        
        while stack:
            cx, cy = stack.pop()
            image[cx][cy] = newColor
            # Get the neighbors
            neighbors = [(a+cx, b+cy) for a,b in [(-1,0), (1,0), (0,-1), (0,1)] if 0 <= a+cx < m and 0 <= b+cy < n and image[a+cx][b+cy] == toreplace]
            stack += neighbors
        return image