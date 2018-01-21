class Solution(object):
    def openLock(self, deadends, target):
        """
        :type deadends: List[str]
        :type target: str
        :rtype: int
        """
        if target == "0000":
            return 0
        if "0000" in deadends:
            return -1
        target = tuple(int(x) for x in target)
        de = set()
        for s in deadends:
            de.add(tuple(int(x) for x in s))
        visited = de
        curval = [((0,0,0,0),  0)]
        while  curval:
            current, depth = curval.pop(0)
            # Get all the positions we can visit from this
            for j in range(4):
                up = current[j]+1
                if up == 10:
                    up = 0
                down = current[j]-1
                if down == -1:
                    down = 9
                nv1 = current[:j] + (up,) + current[j+1:]
                nv2 = current[:j] + (down,) + current[j+1:]
                for nv in [nv1, nv2]:
                    if nv == target:
                        return depth+1
                    if nv not in visited:
                        #print(nv1,nv2)
                        visited.add(nv)
                        curval.append((nv, depth+1))
        return -1
        