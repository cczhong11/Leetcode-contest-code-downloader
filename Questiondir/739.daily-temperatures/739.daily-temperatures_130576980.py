class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        if len(temperatures) == 0:
            return []
        
        result = [0 for i in range(len(temperatures))]
        
        stack = []
        
        for i in range(len(temperatures))[::-1]:
            while stack and temperatures[stack[-1]] <= temperatures[i]:
                stack.pop()
            if stack:
                result[i] = stack[-1] - i
            stack.append(i)
            
        return result
            
        