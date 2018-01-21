class Solution(object):
    def openLock(self, deadends, target):
        """
        :type deadends: List[str]
        :type target: str
        :rtype: int
        """
        # 感觉上像双向宽搜
        Dead = {}
        for dead in deadends:
            Dead[dead] = 1
        D = {}
        Q = []
        Q.append('0000')
        D['0000'] = 1
        step = 0
        if '0000' in Dead:
            return -1
        while len(Q)>0:
            nQ = []
            step += 1
            while len(Q)>0:
                L = Q.pop()
                newL = []
                newL.append(str((int(L[0])+1)%10) + L[1:])
                newL.append(str((int(L[0])-1)%10) + L[1:])
                newL.append(L[0] + str((int(L[1])+1)%10) + L[2:])            
                newL.append(L[0] + str((int(L[1])-1)%10) + L[2:])
                newL.append(L[0:2] + str((int(L[2])+1)%10) + L[3])
                newL.append(L[0:2] + str((int(L[2])-1)%10) + L[3])
                newL.append(L[0:3] + str((int(L[3])+1)%10))
                newL.append(L[0:3] + str((int(L[3])-1)%10))
                for i in newL:
                    if i in Dead:
                        continue
                    if i in D:
                        continue
                    if i == target:
                        return step
                    D[i] = 1
                    nQ.append(i)
            Q = nQ
        return -1
                    
                    
                    
        