class Solution(object):
    def maxA(self, N):
        """
        :type N: int
        :rtype: int
        """
        if N == 0:
            return 0
        minV = 1
        maxV = minV * 2
        failmemo = {}
        successmemo = {}

        #return self.testWithinMemo(10, N, failmemo, successmemo)

        while self.testWithinMemo(maxV, N, failmemo, successmemo):
            minV = maxV
            maxV = minV * 2

        while (maxV > minV):
            mid = (minV + maxV) // 2
            if mid == minV:
                return mid
            if (self.testWithinMemo(mid, N, failmemo, successmemo)):
                minV = mid
            else:
                maxV = mid
        return minV

    def testWithinMemo(self, target, moves, failmemo, successmemo):
        if target in failmemo:
            if failmemo[target] >= moves:
                return False
        if target in successmemo:
            if successmemo[target] <= moves:
                return True
        res = self.testWithin(target, moves, failmemo, successmemo)
        if res:
            successmemo[target] = moves
        else:
            failmemo[target] = moves
        return res

    def testWithin(self, target, moves, failmemo, successmemo):
        if target <= moves:
            return True
        if moves <= 0:
            return False

        for i in range(2, moves):
            newT = (target + i - 1) // i
            newMoves = moves - i - 1
            if self.testWithinMemo(newT, newMoves, failmemo, successmemo):
                return True
        return False