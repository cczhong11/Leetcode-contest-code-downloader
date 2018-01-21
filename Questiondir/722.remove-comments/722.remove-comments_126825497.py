class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        src = "\n".join(source) + '\n'
        CODE = 0
        LINEC = 1
        BLOCKC = 2
        i = 0
        start_c = None
        mode = CODE
        rems = set([])
        jump = False
        for i in xrange(len(src)):
            if jump:
                jump = False
                continue
            print i, src[i], mode
            if mode == CODE:
                if src[i] != '/':
                    continue
                if i+1 == len(src):
                    continue
                if src[i+1] == '/':
                    mode = LINEC
                    start_c = i
                    jump = True
                    continue
                if src[i+1] == '*':
                    mode = BLOCKC
                    start_c = i
                    jump = True
                    continue
            elif mode == LINEC:
                if src[i] == '\n':
                    mode = CODE
                    endc = i+1
                    if start_c > 0 and src[start_c-1] != '\n':
                        endc = i
                    rems |= set(range(start_c, endc))
                continue
            elif mode == BLOCKC:
                if src[i] != '*':
                    continue
                if i+1 == len(src):
                    continue
                if src[i+1] == '/':
                    mode = CODE
                    endc = i+2
                    if i+2 < len(src) and src[i+2] == '\n' and (start_c == 0 or src[start_c-1] == '\n'):
                        endc += 1
                    rems |= set(range(start_c, endc))
                    jump = True
                    #if start_c > 0 and src[start_c-1] != '\n':
                    #    new_lines = [j for j in xrange(start_c, i+3) if j < len(src) and src[j] == '\n']
                    #    if new_lines:
                    #        rems.discard(new_lines[0])
        ret = ''.join([src[i] for i in xrange(len(src)) if i not in rems]).split('\n')
        return [r for r in ret if r]
