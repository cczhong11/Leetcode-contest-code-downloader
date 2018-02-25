class Solution(object):
    def isIdealPermutation(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        if len(A) <= 2:
            return True
        if A[2] < A[0]:
            return False
        if len(A) <= 3:
            return True
        cur_max = max(A[0], A[1])
        for i in range(3, len(A)):
            if A[i] < cur_max:
                return False
            cur_max = max(cur_max, A[i-1])
        return True
        