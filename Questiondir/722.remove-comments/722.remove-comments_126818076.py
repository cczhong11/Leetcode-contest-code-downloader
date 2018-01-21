class Solution(object):
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        outOfBlock,ans = True,[]
        for line in source:
            converted,i,contBlock = [],0,(not outOfBlock)
            while i<len(line):
                if outOfBlock:
                    if line[i:i+2]=="/*":
                        outOfBlock = False
                        i += 2
                        continue
                    elif line[i:i+2]=="//":
                        break
                    else:
                        converted.append(line[i])
                        i += 1
                else:
                    if line[i:i+2]=="*/":
                        outOfBlock = True
                        i += 2
                    else:
                        i += 1
            if len(converted)>0:
                if contBlock:
                    ans[-1] += "".join(converted)
                else:
                    ans.append("".join(converted))
            elif not outOfBlock and not contBlock:
                ans.append("")
        res = [line for line in ans if len(line)>0]
        return res