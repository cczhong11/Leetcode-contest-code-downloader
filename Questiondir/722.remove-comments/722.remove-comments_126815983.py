import re

class Solution:
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        
        r1 = re.compile(r'//')
        r2 = re.compile(r'/\*')
        r3 = re.compile(r'\*/')
        
        i = 0
        while i < len(source):
            m1 = r1.search(source[i])
            m2 = r2.search(source[i])
            if m1 and (not m2 or (m2 and m1.start() < m2.start())):
                source[i] = source[i][0:m1.start()]
                i += 1
                continue
            if m2 and (not m1 or (m1 and m2.start() < m1.start())):
                m3 = r3.search(source[i][m2.end():])
                if m3:
                    source[i] = source[i][:m2.start()] + source[i][m2.end() + m3.end():]
                    continue
                j = i+1
                while True:
                    m3 = r3.search(source[j])
                    if m3:
                        break
                    j += 1
                source[i] = source[i][:m2.start()] + source[j][m3.end():]
                for k in range(i+1, j+1):
                    del source[i+1]
                continue
            # no match
            i += 1
        return [s for s in source if s]