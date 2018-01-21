class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        
        
        res = [0 for _ in range(len(temperatures))]
        
        stack = []
        
        for i in range(len(temperatures)):
            if not stack:
                stack.append(i)
                continue
            
            while stack:
                if temperatures[stack[-1]] < temperatures[i]:
                    j = stack.pop()
                    res[j] = i - j
                else:
                    break
            
            stack.append(i)
        return res