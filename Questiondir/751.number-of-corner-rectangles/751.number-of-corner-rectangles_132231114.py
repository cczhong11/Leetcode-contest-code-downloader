class Solution(object):
    def countCornerRectangles(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m = len(grid)
        n = len(grid[0])
        if(m <= 2 or n <= 2):
            return 0
        res = 0

        dp = []
        for i in range(m):
            dp.append([0]*m)
        
        for i in range(n):
            temp = []
            for j in range(m):
                if(grid[j][i] == 1):
                    temp.append(j)
            for i in range(len(temp)):
                for j in range(i+1,len(temp)):
                    dp[temp[i]][temp[j]] += 1
        
        
        for i in range(m):
            for j in range(i+1,m):
                #count = 0
                #for k in range(n):
                    #if( == 1 and  == 1):
                #    count += grid[i][k] * grid[j][k]
                res += dp[i][j] * (dp[i][j]-1)/2
        return res