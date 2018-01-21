class Solution(object):
    def openLock(self, deadends, target):
        """
        :type deadends: List[str]
        :type target: str
        :rtype: int
        """
        maps = dict([
            ('0', ('9','1')),
            ('1', ('0','2')),
            ('2', ('1','3')),
            ('3', ('2','4')),
            ('4', ('3','5')),
            ('5', ('4','6')),
            ('6', ('5','7')),
            ('7', ('6','8')),
            ('8', ('7','9')),
            ('9', ('8','0')),
                ])
        ded = set(deadends)
        st = '0000'
        if st in ded: return -1
        if target == st: return 0
        q = [(st, 0)]
        mem = set(st)
        while q:
            sig, t = q.pop(0)
            t += 1
            for i in range(4):
                ch = sig[i]
                for rep in maps[ch]:
                    sig2 = sig[:i] + rep + sig[i+1:]
                    if sig2 in mem: continue
                    if sig2 in ded: continue
                    if sig2 == target:
                        return t
                    mem.add(sig2)
                    q.append((sig2, t))
        return -1

