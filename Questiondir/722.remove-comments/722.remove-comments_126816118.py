class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        ans, p, C = [], None, {'/': False, '*': False}
        for c in '\n'.join(source):
            if C['/']:
                if c == '\n':
                    ans.append(c)
                    C['/'] = False
            elif C['*']:
                if p == '*' and c == '/':
                    C['*'] = False
                    c = None
            elif p == '/' and c in C:
                C[c] = True
                c = None
                ans.pop()
            else:
                ans.append(c)
            p = c
        return filter(None, ''.join(ans).split('\n'))