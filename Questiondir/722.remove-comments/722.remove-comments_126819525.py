class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        output = []
        cur_line = ""
        
        block = False
        
        i = 0
        
        while i < len(source):
            line = source[i]
            #print(output, cur_line)
            p1 = line.find("//")
            p2 = line.find("/*")
            p3 = line.find("*/")
            #print(p1,p2,p3,block)
            if block:
                if p3 >= 0:
                    block = False
                    source[i] = cur_line + source[i][p3+2:]
                    cur_line = ""
                    i -= 1
            else:
                if p2 >= 0 and (p2 < p1 or p1<0):
                    block = True
                    cur_line += line[:p2]
                    source[i] = source[i][p2+2:]
                    i -= 1
                elif p1 >= 0:
                    output.append(line[:p1])
                else:
                    output.append(line)
            i += 1
        
        output = [l for l in output if len(l) > 0]
        return output