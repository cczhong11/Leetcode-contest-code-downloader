class Solution(object):
	def evaluate(self, expression):
		"""
		:type expression: str
		:rtype: int
		"""
		def dealwith(x,vals={}):
			# print([x],vals)
			x=x.split()
			if x[0]=='(' and x[-1]==')':
				x=x[1:-1]
			if x[0] not in ['add','mult','let']:
				try:
					r=int(x[0])
					return r
				except:
					return vals[x[0]][-1]
			if x[0]=='add':
				i=1
				c=0
				while not (c==0 and i!=1):
					if x[i]=='(':
						c+=1
					if x[i]==')':
						c-=1
					i+=1
				part1=' '.join(x[1:i])
				part2=' '.join(x[i:])
				return dealwith(part1,vals)+dealwith(part2,vals)
			if x[0]=='mult':
				i=1
				c=0
				while not (c==0 and i!=1):
					if x[i]=='(':
						c+=1
					if x[i]==')':
						c-=1
					i+=1
				part1=' '.join(x[1:i])
				part2=' '.join(x[i:])
				return dealwith(part1,vals)*dealwith(part2,vals)
			if x[0]=='let':
				parts=[]
				i=1
				while i<len(x):
					j=i
					c=0
					while not (c==0 and j!=i):
						if x[j][0]=='(':
							c+=1
						if x[j][-1]==')':
							c-=1
						j+=1
					parts.append(' '.join(x[i:j]))
					i=j
				newv={i:vals[i] for i in vals}
				# print(parts)
				for i in xrange(0,len(parts)-1,2):
					newv[parts[i]]=vals.get(parts[i],[])[:]+[dealwith(parts[i+1],newv)]
				return dealwith(parts[-1],newv)
		return dealwith(expression.replace('(','( ').replace(')',' )'))