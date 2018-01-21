class Solution(object):
    def containVirus(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        ind = 1
        nWalls = 0
        nThreatened = {}  # nThreatened: (i, j)
        iDim = len(grid)
        jDim = 0
        if iDim > 0:
            jDim = len(grid[0])

        def getThreats(i, j, nThreatened):
            # ind = the number that indicates an infected region
            # that hasn't been quarantined
            hasSeen = [[False] * jDim for x in xrange(iDim)]
            nThreatened[nThreat(i, j, hasSeen)] = (i, j)

        def nThreat(i, j, hasSeen):
            if (i < 0 or j < 0 or i >= iDim or j >= jDim):
                return 0
            if hasSeen[i][j]:
                return 0
            hasSeen[i][j] = True
            if grid[i][j] == 0:
                return 1
            if grid[i][j] == 'q':
                # quarantined
                return 0
            # grid[i][j] == ind:
            grid[i][j] = ind + 1
            return nThreat(i - 1, j, hasSeen) + nThreat(i, j - 1, hasSeen) + nThreat(i + 1, j, hasSeen) + nThreat(i, j + 1, hasSeen)

        def quarantine(x, y, ind):
            if grid[x][y] == 'q':
                return 0
            nWalls = 0
            grid[x][y] = 'q'
            for i, j in [(x - 1, y), (x, y - 1), (x + 1, y), (x, y + 1)]:
                if not (i < 0 or j < 0 or i >= iDim or j >= jDim):
                    if grid[i][j] == ind:
                        nWalls += quarantine(i, j, ind)
                    elif grid[i][j] == 0:
                        nWalls += 1
            return nWalls

        def infect(i, j, ind):
            if (i < 0 or j < 0 or i >= iDim or j >= jDim):
                return
            if grid[i][j] == 0:
                # Infect
                grid[i][j] = ind + 1
            if grid[i][j] == ind:
                grid[i][j] = ind + 1 # Mark seen
                infect(i - 1, j, ind)
                infect(i, j - 1, ind)
                infect(i + 1, j, ind)
                infect(i, j + 1, ind)

        while True:
            for i in xrange(iDim):
                for j in xrange(jDim):
                    if grid[i][j] == ind:
                        getThreats(i, j, nThreatened)
            if len(nThreatened) == 0:
                return nWalls
            x, y = nThreatened[max(nThreatened.keys())]
            ind += 1
            nWalls += quarantine(x, y, ind)
            for i in xrange(iDim):
                for j in xrange(jDim):
                    if grid[i][j] == ind:
                        # hasSeen = [[False] * jDim for x in xrange(iDim)]
                        infect(i, j, ind)
            ind += 1
            nThreatened = {}