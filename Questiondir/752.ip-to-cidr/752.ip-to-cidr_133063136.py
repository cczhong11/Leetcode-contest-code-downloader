class Solution(object):
    def b8(self, v):
        ret = []
        for i in xrange(8):
            ret.append((v>>i) & 1)
        return ret
    
    def bton(self, b):
        return int(''.join(map(str, b[::-1])), 2)
    
    def ipbToip(self, ipb):
        return '.'.join([str(self.bton(ipb[8*i:8*i+8])) for i in xrange(4)][::-1])
    
    def ipToCIDR(self, ip, n):
        """
        :type ip: str
        :type range: int
        :rtype: List[str]
        """
        ip4 = map(int, ip.split('.'))
        ipb = self.b8(ip4[3]) + self.b8(ip4[2]) + self.b8(ip4[1]) + self.b8(ip4[0])
        print ipb
        last1 = 32
        for i in xrange(32):
            if ipb[i] == 1:
                last1 = i
                break
        ret = []
        while n > 0:
            pend = 0
            while 2**(pend+1) <= n and ((pend+1) <= last1):
                pend += 1
            ret.append(self.ipbToip(ipb) + '/' + str(32-pend))
            n -= 2**(pend)
            for i in xrange(pend):
                ipb[i] = 0
            i = pend
            while ipb[i] == 1:
                ipb[i] = 0
                i += 1
            ipb[i] = 1
            last1 = i
        return ret        
        