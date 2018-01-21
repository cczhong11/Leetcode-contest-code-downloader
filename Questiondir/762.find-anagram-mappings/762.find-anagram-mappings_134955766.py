class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        ans,aIdxs = [-1]*len(A),{}
        for i,n in enumerate(A):
            if n not in aIdxs:
                aIdxs[n] = []
            aIdxs[n].append(i)
        for i,n in enumerate(B):
            j = aIdxs[n].pop()
            ans[j] = i
        return ans