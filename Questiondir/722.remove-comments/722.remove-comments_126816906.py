class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        src = "\n".join(source) 
        buf = []
        i = 0
        state = 0
        for ch in src:
            if state == 0:
                if ch == '/':
                    state = 1
                else:
                    buf.append(ch)
            elif state == 1:
                if ch == '/':
                    state = 3
                elif ch == '*':
                    state = 2
                else:
                    state = 0
                    buf += ['/', ch]
            elif state == 2:
                if ch == '*':
                    state = 4
            elif state == 3:
                if ch == '\n':
                    state = 0
                    buf.append('\n')
            elif state == 4:
                if ch == '/':
                    state = 0
                elif ch != '*':
                    state = 2
                    
        return filter(lambda s: len(s) > 0, "".join(buf).split("\n"))