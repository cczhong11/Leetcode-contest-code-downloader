class Solution(object):
	def floodFill(self, image, sr, sc, newColor):
		"""
		:type image: List[List[int]]
		:type sr: int
		:type sc: int
		:type newColor: int
		:rtype: List[List[int]]
		"""
		m=len(image)
		n=len(image[0])
		mark=[[0]*n for i in image]
		wait=[[sr,sc]]
		label=image[sr][sc]
		while wait!=[]:
			x,y=wait[0]
			image[x][y]=newColor
			mark[x][y]=1
			wait=wait[1:]
			if 0<=x-1 and mark[x-1][y]==0 and image[x-1][y]==label:
				wait.append([x-1,y])
			if x+1<m and mark[x+1][y]==0 and image[x+1][y]==label:
				wait.append([x+1,y])
			if 0<=y-1 and mark[x][y-1]==0 and image[x][y-1]==label:
				wait.append([x,y-1])
			if y+1<n and mark[x][y+1]==0 and image[x][y+1]==label:
				wait.append([x,y+1])
		return image