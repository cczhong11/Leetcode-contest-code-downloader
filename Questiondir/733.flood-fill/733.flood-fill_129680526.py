class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        oldColor = image[sr][sc]
        R = len(image)
        C = len(image[0])
    
        queue = [(sr, sc)]
        seen = set()
        
        while queue:
            r, c = queue.pop(0)
            if 0 <= r < R and 0 <= c < C and (r,c) not in seen and image[r][c] == oldColor:
                image[r][c] = newColor
                seen.add((r, c))
                queue += [
                    (r+1, c),
                    (r, c+1),
                    (r-1, c),
                    (r, c-1),
                ]
        return image