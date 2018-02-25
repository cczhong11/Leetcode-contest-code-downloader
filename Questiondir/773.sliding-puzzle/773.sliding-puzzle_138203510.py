class Solution(object):
    def slidingPuzzle(self, board):
        """
        :type board: List[List[int]]
        :rtype: int
        """
        from copy import deepcopy
        visited = set()
        queue = [board]
        new_queue = []
        result = tuple([1,2,3]+[4,5,0])
        res = 0
        while queue and res < 30:
            while queue:
                node = queue.pop()
                tuple_node = tuple(node[0]+node[1])
                if tuple_node not in visited:
                    visited.add(tuple_node)
                    if tuple_node == result:
                        return res
                    for i in range(2):
                        for j in range(3):
                            if node[i][j] == 0:
                                for x, y in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
                                    if 0 <= x < 2 and 0 <= y < 3:
                                        new_res = deepcopy(node)
                                        new_res[i][j], new_res[x][y] = new_res[x][y], new_res[i][j]
                                        new_queue.append(new_res)
            queue = new_queue
            new_queue = []
            res += 1
        return -1
        
        