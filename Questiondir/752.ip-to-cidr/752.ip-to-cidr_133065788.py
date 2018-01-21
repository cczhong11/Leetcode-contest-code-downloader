class Solution(object):
    def ipToCIDR(self, ip, n):
        a = ip.split('.')
        print ip
        ip = str(ip)
        print type(ip)
        st = 0
        print a
        for i in a:
            st = st * 256 + int(i)
        b = []
        cur = st
        for i in xrange(n):
            b.append(i + cur)
        
        ans = []
        l = len(b)
        i = 0
        while True:
            j = 0
            cur = b[i]
            while True:
                if cur & (1<<j) ==0:
                    rem = l - i
                    #print "can make ",1<<j,"but allowed",rem,"from",i
                    if rem <= (1<<j):
                        break
                else:
                    break
                j+=1
            #print i,"{0:b}".format(cur),j
            rem = l - i
            if (1<<j) > rem:
                j-=1
            ans.append((cur,j))
            i+=(1<<j)
            if i>=l:
                break
        res = []
        for x,y in ans:
            f = []
            st = 4
            while st:
                f.append(str(x%256))
                x/=256
                st-=1
            f.reverse()
            z = '.'.join(f)
            res.append(z + "/" + str(32-y))
        return res