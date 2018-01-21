class Solution:
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        
        output = []
        
        block_comment = False
        cur_line = []
        
        for line in source:
            line_pos = 0
            
            while line_pos < len(line):
                if block_comment:
                    line_pos = line.find("*/", line_pos)
                    
                    if line_pos == -1:
                        break
                        
                    block_comment = False
                    line_pos += 2
                else:
                    block_start_pos = line.find("/*", line_pos)
                    line_comment_start_pos = line.find("//", line_pos)
                    
                    if line_comment_start_pos != -1 and (block_start_pos == -1 or block_start_pos > line_comment_start_pos):
                        cur_line.append(line[line_pos:line_comment_start_pos])
                        break
                    elif block_start_pos != -1:
                        cur_line.append(line[line_pos:block_start_pos])
                        line_pos = block_start_pos + 2
                        block_comment = True
                    else:
                        cur_line.append(line[line_pos:])
                        break
            
            if not block_comment:
                cur_line = "".join(cur_line)

                if cur_line:
                    output.append(cur_line)
                
                cur_line = []
                
        return output
                    
                        
            
        