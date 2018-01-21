xrange = range


class Solution:
    def ipToCIDR(self, ip, range):
        """
        :type ip: str
        :type range: int
        :rtype: List[str]
        """
        n = range
        
        ts = ip.split(".")
        p = 0
        for t in ts:
            p = (p << 8) | int(t)
            
        def gen_ip(p, i):
            res = []
            for j in xrange(4):
                res.append(str((p >> (24 - 8 * j) & 0xFF)))
            return ".".join(res) + "/" + str((32 - i))

        res = []
        while n:
            for i in xrange(32):
                if (p >> i) & 1:
                    break
            cap = 2 ** i
            while cap > n:
                cap >>= 1
                i -= 1
            res.append(gen_ip(p, i))
            p += cap
            n -= cap
                    
        return res