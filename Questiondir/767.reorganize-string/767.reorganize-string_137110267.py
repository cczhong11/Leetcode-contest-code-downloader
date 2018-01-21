class Solution(object):
    def reorganizeString(self, S):
        """
        :type S: str
        :rtype: str
        """
        counts = {}
        for c in S:
            if c not in counts:
                counts[c] = 0
            counts[c] += 1
        most = max(counts.values())
        left = len(S)-most
        if most<=left+1:
            chunks = [[] for _ in xrange(most+1)]
            keys = sorted(counts.keys(),key = lambda k:counts[k])
            for i in xrange(1,most+1):
                chunks[i].append(keys[-1])
            curI = 1
            for k in keys[-2::-1]:
                while counts[k]>0:
                    chunks[curI].append(k)
                    curI = (curI+1)%(most+1)
                    counts[k] -= 1
            chunks = map(lambda l:"".join(l),chunks)
            return "".join(chunks)
        else:
            return ""