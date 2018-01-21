class Solution(object):
	def containVirus(self, grid):
		"""
		:type grid: List[List[int]]
		:rtype: int
		"""
		m=len(grid)
		n=len(grid[0])
		c=0
		wall=[[0]*n for i in xrange(m)]
		for i in xrange(m):
			wall[i][0]^=4
			wall[i][-1]^=8
		for i in xrange(n):
			wall[0][i]^=1
			wall[-1][i]^=2
		while True:
			mask=[[-1]*n for i in xrange(m)]
			seg=0
			mem={}
			for i in xrange(m):
				for j in xrange(n):
					if grid[i][j] and mask[i][j]==-1:
						l=[[i,j]]
						mem[seg]=[]
						while len(l)!=0:
							x,y=l[0]
							mem[seg].append([x,y])
							if mask[x][y]==seg:
								l.pop(0)
								continue
							mask[x][y]=seg
							if 0<=x-1 and grid[x-1][y] and wall[x][y]&1!=1 and mask[x-1][y]==-1:
								l.append([x-1,y])
							if x+1<m and grid[x+1][y] and (wall[x][y]>>1)&1!=1 and mask[x+1][y]==-1:
								l.append([x+1,y])
							if 0<=y-1 and grid[x][y-1] and (wall[x][y]>>2)&1!=1 and mask[x][y-1]==-1:
								l.append([x,y-1])
							if y+1<n and grid[x][y+1] and (wall[x][y]>>3)&1!=1 and mask[x][y+1]==-1:
								l.append([x,y+1])
							l.pop(0)
						seg+=1
			if seg==0:
				return c
			sur={}
			maxs,mi=None,None
			for i in xrange(seg):
				poses=mem[i]
				temp=[]
				for x,y in poses:
					if 0<=x-1 and grid[x-1][y]==0 and wall[x][y]&1!=1:
						temp.append((x-1,y))
					if x+1<m and grid[x+1][y]==0 and (wall[x][y]>>1)&1!=1:
						temp.append((x+1,y))
					if 0<=y-1 and grid[x][y-1]==0 and (wall[x][y]>>2)&1!=1:
						temp.append((x,y-1))
					if y+1<n and grid[x][y+1]==0 and (wall[x][y]>>3)&1!=1:
						temp.append((x,y+1))
				temp=set(temp)
				sur[i]=temp
				if maxs is None:
					maxs,mi=len(temp),i
				elif len(temp)>maxs:
					maxs,mi=len(temp),i
			if maxs==0:
				return c
			for x,y in mem[mi]:
				if 0<=x-1 and grid[x-1][y]==0 and wall[x][y]&1!=1:
					c+=1
					wall[x][y]^=1
					wall[x-1][y]^=2
				if x+1<m and grid[x+1][y]==0 and (wall[x][y]>>1)&1!=1:
					c+=1
					wall[x][y]^=2
					wall[x+1][y]^=1
				if 0<=y-1 and grid[x][y-1]==0 and (wall[x][y]>>2)&1!=1:
					c+=1
					wall[x][y]^=4
					wall[x][y-1]^=8
				if y+1<n and grid[x][y+1]==0 and (wall[x][y]>>3)&1!=1:
					c+=1
					wall[x][y]^=8
					wall[x][y+1]^=4
			for i in xrange(seg):
				if i==mi:
					continue
				poses=sur[i]
				for x,y in poses:
					grid[x][y]=1