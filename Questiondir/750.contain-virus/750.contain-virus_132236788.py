class Solution(object):
    def containVirus(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m, n = len(grid), len(grid[0])
        W = [[0] * n for _ in range(m)]
        M = [[0] * n for _ in range(m)]
        def flood(x,y,idx):
            grid[x][y] = idx
            q = [(x,y)]
            region = [(x,y)]
            while q:
                a,b = q.pop()
                for c,d in [(a+1,b), (a,b+1), (a-1,b), (a,b-1)]:
                    if 0<=c<m and 0<=d<n and grid[c][d] == 1:
                        grid[c][d] = idx
                        q.append((c,d))
                        region.append((c,d))
            return region
        def border(region, rid):
            aff_list = set()
            for a,b in region:
                if a+1 < m and W[a][b] == 0 and grid[a+1][b] != rid:
                    aff_list.add((a+1, b))
                if a-1 >= 0 and W[a-1][b] == 0 and grid[a-1][b] != rid:
                    aff_list.add((a-1, b))
                if b+1 < n and M[a][b] == 0 and grid[a][b+1] != rid:
                    aff_list.add((a, b+1))
                if b-1 >= 0 and M[a][b-1] == 0 and grid[a][b-1] != rid:
                    aff_list.add((a, b-1))
            return aff_list
        def affect_count(aff_list):
            return sum(int(grid[x][y]==0) for (x,y) in aff_list)
        def build_wall(region, rid):
            cnt = 0
            for a,b in region:
                if a+1 < m and W[a][b] == 0 and grid[a+1][b] == 0:
                    W[a][b] = 1
                    cnt += 1
                if a-1 >= 0 and W[a-1][b] == 0 and grid[a-1][b] == 0:
                    W[a-1][b] = 1
                    cnt += 1
                if b+1 < n and M[a][b] == 0 and grid[a][b+1] == 0:
                    M[a][b] = 1
                    cnt += 1
                if b-1 >= 0 and M[a][b-1] == 0 and grid[a][b-1] == 0:
                    cnt += 1
                    M[a][b-1] = 1
            return cnt
        ans = 0
        aff = sum(sum(row) for row in grid)
        while True:
            reg_id = 2
            reg_dic = {}
            for x in range(m):
                for y in range(n):
                    if grid[x][y] == 1:
                        region = flood(x,y, reg_id)
                        reg_dic[reg_id] = region
                        reg_id += 1
            if not reg_dic: break
            reg_bord = dict((rid, border(reg_dic[rid], rid)) for rid in reg_dic.keys())
            reg_aff_list = sorted([(affect_count(reg_bord[rid]), rid) for rid in reg_bord.keys()])[::-1]
            cc, pid = reg_aff_list[0] 
            if cc == 0: break
            ans += build_wall(reg_dic[pid], pid)
            for x,y in reg_dic[pid]:
                grid[x][y] = 0
            del reg_dic[pid]
            for rid in reg_dic.keys():
                if rid not in reg_dic:
                    continue
                for (x,y) in reg_bord[rid]:
                    grid[x][y] = rid
            for x in range(m):
                for y in xrange(n):
                    grid[x][y] = int(grid[x][y] >= 1)
            aff2 = sum(sum(row) for row in grid)
            if aff2 == aff:
                break
            aff = aff2
        return ans

