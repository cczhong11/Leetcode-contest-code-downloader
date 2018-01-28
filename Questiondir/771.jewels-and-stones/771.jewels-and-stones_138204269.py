class Solution(object):
    def slidingPuzzle(self, board):
        """
        :type board: List[List[int]]
        :rtype: int
        """
        start = tuple(i for j in board for i in j)
        end = (1,2,3,4,5,0)
        if start == end:
            return 0
        visited = set()
        visited.add(start)
        toDo = [start]
        result = 1
        
        while toDo:
            newTo = []
            for td in toDo:
                id0 = td.index(0)
                if id0 == 0:
                    temp = (td[3],td[1],td[2],td[0],td[4],td[5])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                    temp = (td[1],td[0],td[2],td[3],td[4],td[5])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                elif id0 == 1:
                    temp = (td[0],td[4],td[2],td[3],td[1],td[5])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                    temp = (td[1],td[0],td[2],td[3],td[4],td[5])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                    temp = (td[0],td[2],td[1],td[3],td[4],td[5])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                elif id0 == 2:
                    temp = (td[0],td[1],td[5],td[3],td[4],td[2])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                    temp = (td[0],td[2],td[1],td[3],td[4],td[5])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                elif id0 == 3:
                    temp = (td[3],td[1],td[2],td[0],td[4],td[5])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                    temp = (td[0],td[1],td[2],td[4],td[3],td[5])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                elif id0 == 4:
                    temp = (td[0],td[4],td[2],td[3],td[1],td[5])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                    temp = (td[0],td[1],td[2],td[4],td[3],td[5])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                    temp = (td[0],td[1],td[2],td[3],td[5],td[4])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                else:
                    temp = (td[0],td[1],td[5],td[3],td[4],td[2])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
                    temp = (td[0],td[1],td[2],td[3],td[5],td[4])
                    if temp not in visited:
                        if temp == end:
                            return result
                        visited.add(temp)
                        newTo.append(temp)
            toDo = newTo
            result += 1          
            
        return -1