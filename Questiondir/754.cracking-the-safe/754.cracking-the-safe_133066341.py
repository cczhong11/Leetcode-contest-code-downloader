class Solution(object):
    def __init__(self):
        self.dic = {}
        self.n = 0
        self.k = 0

    def crackSafe(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        self.n = n
        self.k = k

        if n == 1:
            res = ""
            for i in range(k):
                res += str(i)
            return res
        else:
            start = ""
            cur = []
            for i in range(n):
                start += '0'
                cur.append('0')
            self.dic[start] = True
            self.search(start, cur, pow(k, n)-1)

            return ''.join(cur)

    def search(self, start, cur, rem):
        if rem == 0:
            return True

        for i in range(self.k):
            temp = start[1:] + str(i)
            if temp not in self.dic or self.dic[temp] == False:
                self.dic[temp] = True
                cur.append(str(i))
                if self.search(temp, cur, rem - 1):
                    return True
                cur.pop()
                self.dic[temp] = False
        return False
