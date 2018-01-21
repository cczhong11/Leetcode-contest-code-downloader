class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        import heapq
        
        import collections
        C=collections.Counter(tasks)
        Q=collections.deque()
        
        Heap=[ [ -C[key],key ] for key in C]
        heapq.heapify(Heap)
        
        List=[]
        
        i=-1
        while(Heap or Q):
            i+=1
            if len(Heap)>0:
                Value,Task=heapq.heappop(Heap)
                if Value+1<0:
                    Q.append( (Task,Value+1,i) )
                List.append(Task)
            else:
                List.append('idle')
                
            if len(Q)>0 and i-Q[0][2]>=n:
                Task,V,time=Q.popleft()
                heapq.heappush(Heap,[V,Task])
        return len(List)
                
        
        