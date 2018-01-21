class Solution(object):
    def countCornerRectangles(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        m = len(grid[0])
        ones = [set() for _ in xrange(n)]
        for i in xrange(n):
            for j in xrange(m):
                if grid[i][j] == 1:
                    ones[i].add(j);
        ans = 0
        for i in xrange(n):
            for j in xrange(i + 1, n):
                and_ones = len(ones[i] & ones[j])
                ans += and_ones * (and_ones - 1) / 2
        return ans
                
                    
                
            
        