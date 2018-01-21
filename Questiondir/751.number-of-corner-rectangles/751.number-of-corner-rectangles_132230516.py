class Solution(object):
    def countCornerRectangles(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        count = 0
        fact = [1]
        for j in xrange(1, len(grid[0]) + 1):
            fact.append(fact[-1] * j)
        locations = []
        for i in xrange(len(grid)):
            locations.append(set([j for j in xrange(len(grid[i])) if grid[i][j]]))
        for i in xrange(len(grid)):
            for j in xrange(i + 1, len(grid)):
                n = len(locations[i] & locations[j])
                if n > 0:
                    count += fact[n] / fact[n - 2] / 2
        return count
    