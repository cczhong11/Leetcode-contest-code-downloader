class Solution:
    def openLock(self, deadends, target):
        # BFS for the target
        deadends = set(deadends)
        level = ['0000']
        visited = set('0000')
        nLevel = 0
        if '0000' in deadends or target in deadends: return -1
        while level:
            nLevel += 1
            newLevel = []
            for curr in level:
                for i in range(4):
                    for j in [(int(curr[i]) - 1) % 10, (int(curr[i]) + 1) % 10]:
                        candidate = curr[:i] + str(j) + curr[i + 1:]
                        if candidate not in visited and candidate not in deadends:
                            newLevel.append(candidate)
                            visited.add(candidate)
                        if candidate == target:
                            return nLevel
            level = newLevel
        return -1