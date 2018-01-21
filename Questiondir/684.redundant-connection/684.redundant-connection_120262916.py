class Solution(object):
    def findRedundantConnection(self, edges):
        """
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        toList = [[] for _ in range(2010)]
        edgeD = set()
        nodeSet = set()
        for e in edges:
            toList[e[0]].append(e[1])
            toList[e[1]].append(e[0])
            if (e[1],e[0]) in edgeD:
                return e
            edgeD.add((e[0],e[1]))
            nodeSet.add(e[0])
            nodeSet.add(e[1])
        visited = [0]*2010
        def dfs(cur, prev, expNum, banFrom, banTo):
            if visited[cur] == expNum:
                return False
            visited[cur] = expNum
            for to in toList[cur]:
                if to != prev:
                    if (cur==banFrom and to==banTo) or (to==banFrom and cur==banTo):
                        continue
                    if not dfs(to, cur, expNum, banFrom, banTo):
                        return False
            return True
        expCount = 1
        nodeList = list(nodeSet)
        for e in edges[::-1]:
            if dfs(nodeList[0], -1, expCount, e[0], e[1]):
                if all([visited[node] == expCount for node in nodeList]):
                    return e
            expCount += 1
