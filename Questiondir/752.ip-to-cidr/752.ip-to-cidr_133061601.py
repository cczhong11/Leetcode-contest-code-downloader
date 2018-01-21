class Solution(object):
    def ipToCIDR(self, ip, n):
        """
        :type ip: str
        :type range: int
        :rtype: List[str]
        """
        st = 0
        self.dict = dict()
        for i in range(4*8):
            self.dict[1<<i] = str(4*8 - i)
        for item in ip.split('.'):
            st = (st << 8) + int(item)
        return self.search(st, n)
    def search(self, st, n):
        def int_to_ip(a):
            tmp = []
            for i in range(4):
                tmp.append(a & ((1<<8)-1))
                a >>= 8
            return '.'.join(str(x) for x in tmp[::-1])
        last_bit = st & (-st)
        while last_bit > n:
            last_bit >>= 1
        ans = [int_to_ip(st) + '/' + self.dict[last_bit]]
        if last_bit < n:
            ans += self.search(st+last_bit, n-last_bit)
        return ans

