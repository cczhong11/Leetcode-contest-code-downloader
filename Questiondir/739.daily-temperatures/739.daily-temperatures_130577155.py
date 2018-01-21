class Solution:
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        n = len(temperatures)
        rtn = [0] * n
        # Maintain a stack which stores indices of decreasing values
        st = []
        for i in range(n):
            while st and temperatures[st[-1]] < temperatures[i]:
                rtn[st[-1]] = i - st[-1]
                st.pop()
            st.append(i)
        return rtn