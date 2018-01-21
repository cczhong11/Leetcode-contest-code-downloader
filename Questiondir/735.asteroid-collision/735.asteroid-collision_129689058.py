class Solution(object):
	def asteroidCollision(self, asteroids):
		"""
		:type asteroids: List[int]
		:rtype: List[int]
		"""
		n=len(asteroids)
		size=[abs(i) for i in asteroids]
		arg=sorted(range(n),key=lambda x:size[x])[::-1]
		mark=[True]*n
		# minus=[None]*n
		# vmin=None
		# for i in xrange(n-1,-1,-1):
		# 	minus[i]=vmin
		# 	vmin=vmin if asteroids[i]>0 else (min(asteroids[i],vmin) if vmin is not None else asteroids[i])
		# plus=[None]*n
		# vmax=None
		# for i in xrange(n):
		# 	plus[i]=vmax
		# 	vmax=vmax if asteroids[i]<0 else (max(asteroids[i],vmax) if vmax is not None else asteroids[i])
		newl=[[asteroids[i],i] for i in xrange(n)]
		while newl!=[]:
			m=len(newl)
			p=0
			while p<m and newl[p][0]<0:
				p+=1
			newl=newl[p:]
			m=len(newl)
			q=m-1
			while q>=0 and newl[q][0]>0:
				q-=1
			newl=newl[:q+1]
			m=len(newl)
			t=[]
			i=0
			while i<m:
				if i+1>=m:
					if mark[newl[i][1]]:
						t.append(newl[i])
					i+=1
					continue
				if newl[i][0]>0 and newl[i+1][0]<0:
					if abs(newl[i][0])==abs(newl[i+1][0]):
						mark[newl[i][1]]=False
						mark[newl[i+1][1]]=False
					elif abs(newl[i][0])>abs(newl[i+1][0]):
						mark[newl[i+1][1]]=False
						if mark[newl[i][1]]:
							t.append(newl[i])
					elif abs(newl[i][0])<abs(newl[i+1][0]):
						mark[newl[i][1]]=False
					i+=1
					continue
				if mark[newl[i][1]]:
					t.append(newl[i])
				i+=1

			newl=t
			# # print(newl)
			# for i in xrange(m-1,-1,-1):
			# 	if len(newl)>i+1:
			# 		if newl[i][0]>0 and newl[i+1][0]<0:
			# 			if abs(newl[i][0])==abs(newl[i+1][0]):
			# 				mark[newl[i][1]]=False
			# 				mark[newl[i+1][1]]=False
			# 				newl=newl[:i]+newl[i+2:]
			# 			elif abs(newl[i][0])>abs(newl[i+1][0]):
			# 				mark[newl[i+1][1]]=False
			# 				newl=newl[:i+1]+newl[i+2:]
			# 			elif abs(newl[i][0])<abs(newl[i+1][0]):
			# 				mark[newl[i][1]]=False
			# 				newl=newl[:i]+newl[i+1:]
		return [asteroids[i] for i in xrange(n) if mark[i]]
