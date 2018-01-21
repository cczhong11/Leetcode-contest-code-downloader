class Solution(object):
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        sol = []
        for n in range(left, right + 1):
            digs = map(int,list(str(n)))
            if 0 in digs:
                continue
            good = True
            for d in digs:
                if n % d != 0:
                    good = False
                    break
            if good:
                sol.append(n)
        return sol