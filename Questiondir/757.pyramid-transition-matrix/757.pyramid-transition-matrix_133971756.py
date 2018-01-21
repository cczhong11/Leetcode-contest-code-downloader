class Solution(object):
    def pyramidTransition(self, bottom, allowed):
        """
        :type bottom: str
        :type allowed: List[str]
        :rtype: bool
        """
        def backtracking(level, ind, lb):
            if level == lb - 1:
                return True
            key = (pyr[level][ind], pyr[level][ind+1])
            if key not in hmall:
                return False
            for v in hmall[key]:
                pyr[level + 1][ind] = v
                if level + ind >= lb - 2:
                    if backtracking(level + 1, 0, lb):
                        return True
                else:
                    if backtracking(level, ind + 1, lb):
                        return True
            return False
        
        hmall = {}
        for i,j,k in allowed:
            if (i,j) in hmall:
                hmall[(i,j)].append(k)
            else:
                hmall[(i,j)] = [k]
        lb = len(bottom)
        pyr = [["" for _ in range(lb)] for _ in range(lb)]
        pyr[0] = list(bottom)
        return backtracking(0,0,lb)
        