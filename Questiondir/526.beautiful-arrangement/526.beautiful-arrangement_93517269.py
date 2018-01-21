class Solution(object):
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        def Try(flags, N, idx):
            if idx < 1: return 1
            counter = 0
            for i in range(1, N+1):
                if flags[i - 1] == False:
                    if idx % i == 0 or i % idx == 0:
                        flags[i - 1] = True
                        counter += Try(flags, N, idx - 1)
                        flags[i - 1] = False
            return counter
        def Try2(flags, N, results):
            if all(flags):
                return results#1
            counter = []#0
            if any(flags):
                idx = flags.index(True)
            else:
                idx = N
            for i in range(1, N+1):
                if flags[i - 1] == False:
                    if idx % i == 0 or i % idx == 0:
                        flags[i - 1] = True
                        results.append(i)
                        counter += Try(flags, N, results)
                        results.pop()
                        flags[i - 1] = False
            return counter
        flags = [False] * N
        return Try(flags, N, N)
