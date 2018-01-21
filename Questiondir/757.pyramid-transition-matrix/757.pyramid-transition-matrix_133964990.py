from collections import defaultdict
class Solution(object):
    def pyramidTransition(self, bottom, allowed):
        """
        :type bottom: str
        :type allowed: List[str]
        :rtype: bool
        """
        n = len(bottom)
        last = [set(x) for x in bottom]
        rules = defaultdict(set)
        for a,b,c in allowed:
            rules[(a,b)].add(c)
        for ii in range(n-1, 0, -1):
            cur = [None for _ in range(ii)]
            for j in range(ii):
                lef = last[j]
                rig = last[j+1]
                tgt = set()
                for x in lef:
                    for y in rig:
                        res = rules.get((x,y), None)
                        if res is not None:
                            tgt = tgt | res
                if len(tgt) == 0:
                    return False
                cur[j] = tgt
            last = cur
        return True

