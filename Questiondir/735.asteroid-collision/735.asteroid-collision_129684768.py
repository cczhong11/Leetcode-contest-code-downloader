class Solution:
    def solve(self, asteroids, dirs):
        N = len(asteroids)
        
        output = []
        n_output = []
        
        st = []
        
        for i in range(N):
            if dirs[i] == -1:
                while len(st) and st[-1] < asteroids[i]:
                    st.pop()
                if len(st) and st[-1] == asteroids[i]:
                    st.pop()
                elif not st:
                    output.append(-asteroids[i])
            else:
                st.append(asteroids[i])
                
        #print (output)
        
        st = []
        for i in range(N - 1, -1, -1):
            if dirs[i] == 1:
                while len(st) and st[-1] < asteroids[i]:
                    st.pop()
                if len(st) and st[-1] == asteroids[i]:
                    st.pop()
                elif not st:
                    n_output.append(asteroids[i])
            else:
                st.append(asteroids[i])
        
        return output + list(reversed(n_output))
        
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        
        dirs = [-1 if el < 0 else 1 for el in asteroids]
        asteroids = [abs(el) for el in asteroids]
#         alive1 = self.solve(asteroids, dirs)
        
#         dirs = [1 - el for el in dirs]
#         alive2 = self.solve(list(reversed(asteroids)), dirs)
        
        output = self.solve(asteroids, dirs)
    
        return output