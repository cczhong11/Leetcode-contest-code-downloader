class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        ans = []
        multi = False
        i = 0 
        while i < len(source):
            cur = source[i]
            if multi:
                p = cur.find('*/')
                if p == -1:
                    i += 1
                    continue
                cur = cur[p+2:]
                if ans:
                    cur = ans[-1] + cur
                    ans.pop()
                multi = False
            p = cur.find('/*')
            q = cur.find('//')
            if (p == -1 and q >= 0) or (p > q >= 0):
                cur = cur[:q]
            elif (q == -1 and p >= 0) or (q > p >= 0):
                q = cur.find('*/', p+2)
                if q == -1:
                    cur = cur[:p]
                    multi = True
                else:
                    cur = cur[:p] + cur[q+2:]
                    source[i] = cur
                    continue
            if len(cur) > 0:
                ans.append(cur)
            i += 1
        return ans