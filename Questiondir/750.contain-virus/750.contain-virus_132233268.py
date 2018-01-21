class Solution(object):
    def containVirus(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        return _containVirus(grid)

def _containVirus(grid):
    result = 0
    walls = oneStep(grid)
    while walls > 0:
        result += walls
        walls = oneStep(grid)
    return result
    
def oneStep(grid):
    compThreats = findComponentsAndThreats(grid)

    if len(compThreats) == 0:
        return 0
    compThreats.sort(key = lambda x: len(set(x[0])))
    willFix = compThreats[-1]
    walls = len(willFix[0])
    if walls == 0:
        return 0
    setIndices(grid, willFix[1], -2)
    for threat, comp in compThreats[:-1]:
        setIndices(grid, threat, 1)
        setIndices(grid, comp, 1)
    return walls
    

def setIndices(grid, indices, val):
    for i, j in indices:
        grid[i][j] = val

def findComponentsAndThreats(grid):
    # traversed = flip sign
    N = len(grid)
    M = len(grid[0])
    result = []
    for i in xrange(N):
        for j in xrange(M):
            if grid[i][j] <= 0:
                continue
            elif grid[i][j] == 1:
                result.append(detectComponent(grid, i, j, N, M))
    
    return result

def detectComponent(grid, i, j, N, M):
    threatened = list()
    next = [(i, j)]
    component = set()
    while next:
        i, j = next.pop()
        if grid[i][j] < 0:
            continue
        component.add((i,j))
        grid[i][j] *= -1
        for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
            i2, j2 = i+dx, j + dy
            if i2 < 0 or i2 >= N or j2 < 0 or j2 >= M:
                continue
            if grid[i2][j2] == 0:
                threatened.append((i2, j2))
            elif grid[i2][j2] == 1:
                next.append((i2, j2))
    return threatened, component