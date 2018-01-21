class Solution(object):
    def makeLargestSpecial(self, S):
        """
        :type S: str
        :rtype: str
        """
        def get(s):
            if len(set(s[:len(s)//2]))==1:
                return s
            # print(s)
            count=0
            best=None
            m={}
            for i in xrange(len(s)):
                if i!=0 and s[i]=='1' and s[i-1]=='0':
                    if best is None:
                        best=count
                    elif count<best:
                        best=count
                m[count]=m.get(count,[])+[i]
                count+=1 if s[i]=='1' else -1
            m[0].append(len(s))
            if best is None:
                return s
            sel=m[best]
            # print(sel,best,m)
            pre=s[:sel[0]]
            suf=s[sel[-1]:]
            seg=[s[sel[i]:sel[i+1]] for i in xrange(len(sel)-1)]
            # print(pre,suf,seg)
            if len(seg)<=1:
                return s
            seg=[get(i) for i in seg]
            seg.sort()
            s=pre+''.join(seg[::-1])+suf
            return s
        return get(S)