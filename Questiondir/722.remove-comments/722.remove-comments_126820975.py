class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        block = False
        ret = []
        line = 0
        pos = 0
        cur = ''
        while line< len(source):
            # print pos, cur, line
            if block:
                block_c = source[line][pos:].find('*/')
                if block_c == -1:
                    line+=1
                    pos = 0
                else:
                    pos = block_c+2+pos
                    block = False
            else:
                line_c = source[line][pos:].find('//')
                block_c = source[line][pos:].find('/*')
                if line_c!=-1 and (block_c == -1 or line_c < block_c):
                    if line_c>0:
                        cur += source[line][pos:pos+line_c]
                    if cur:    
                        ret.append(cur)
                        cur = ''
                    line+=1
                    pos = 0
                elif block_c!= -1:
                    block = True
                    if block_c>0:
                        cur += source[line][pos:pos+block_c]
                    pos = block_c+2+pos
                else:
                    if pos < len(source[line]):
                        cur += source[line][pos:]
                    if cur:
                        ret.append(cur)
                        cur = ''
                    line+=1
                    pos = 0
        return ret