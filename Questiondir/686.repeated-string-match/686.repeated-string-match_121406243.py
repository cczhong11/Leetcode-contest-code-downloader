class Solution(object):
    def repeatedStringMatch(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """
        if A is None and B is None:
            return 0
        Alen = len(A)
        startPosList = []
        for i in range(len(A)):
            if A[i] == B[0]:
                startPosList.append(i)
        ans = None
        if set(B) > set(A):
            return -1
        for startPos in startPosList:
            i = startPos
            fail = False
            thisCount = 1
            for cB in B:
                if i == Alen:
                    i %= Alen
                    thisCount += 1

                if cB != A[i]:
                    fail = True
                    break
                i += 1
            if not fail:
                ans = thisCount
                break
                # if ans is None or thisCount < ans:
                #     ans = thisCount
        if ans is None:
            return -1
        return ans
