class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        s = '\n'.join(source)
        print s
        f = 0
        n = len(s)
        t = ''
        i = 0
        while i < n:
            print i, s[i], f
            of = f
            if f == 1 and s[i] == '\n':
                f = 0
                t += '\n'
            elif f == 2 and s[i:i+2] == '*/':
                f = 0
                i += 1
            elif f == 0:
                if s[i:i+2] == '//':
                    print i, s[i:i+2]
                    f = 1
                    i += 1
                elif s[i:i+2] == '/*':
                    print i, s[i:i+2]
                    f = 2
                    i += 1
            if of == 0 and f == 0:
                t += s[i]
            i += 1
        return filter(lambda x: len(x) > 0, t.split('\n'))
