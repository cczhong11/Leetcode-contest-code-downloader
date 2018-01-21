class Solution:
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        stack = [(sr, sc)]
        oldColor = image[sr][sc]
        if oldColor == newColor:
            return image
        while stack:
            pr, pc = stack.pop()
            if image[pr][pc] == oldColor:
                image[pr][pc] = newColor
                for i, j in [(pr - 1, pc), (pr + 1, pc), (pr, pc - 1),(pr, pc + 1)]:
                    if 0 <= i < len(image) and 0 <= j < len(image[0]):
                        stack.append((i,j))
        return image