class Solution(object):
    def openLock(self, deadends, target):
        """
        :type deadends: List[str]
        :type target: str
        :rtype: int
        """
        visited = set(deadends)
        s1 = set(["0000"])
        s2 = set([target])
        
        
        if "0000" in deadends:
            return -1
        if s1 == s2:
            return 0
        cnt = 0
        while s1 and s2:
            
            s_tmp = set()
            while s1:
                pattern = s1.pop()
                if pattern in s2:
                    return cnt
                visited.add(pattern)
                for i in range(4):
                    x = pattern[i]
                    p1 = pattern[:i] + str((int(x)+1)%10) + pattern[i+1:]
                    p2 = pattern[:i] + str((int(x)-1)%10) + pattern[i+1:]
                    if p1 not in visited:
                        s_tmp.add(p1)
                    if p2 not in visited:
                        s_tmp.add(p2)
            s1 = s_tmp
            s1, s2 = s2, s1
            cnt += 1
            
        return -1
            