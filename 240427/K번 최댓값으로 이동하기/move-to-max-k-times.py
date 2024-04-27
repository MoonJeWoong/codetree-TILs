from collections import deque

DEBUG = True
dprint = lambda x: print(x) if DEBUG else False

N, K = list(map(int,input().split()))
board = list()
for i in range(N):
    line = list(map(int,input().split()))
    board.append(line)

r, c = list(map(int,input().split()))
x, y = r-1, c-1

adj_points = lambda x,y: [(x+dx,y+dy) for dx,dy in [(-1,0),(0,1),(1,0),(0,-1)]]
is_bound = lambda x,y: True if (0<=x<N and 0<=y<N) else False

def move_next(x,y):
    x_val = board[x][y]

    candidiate = list()
    visited =set()
    que = deque()

    que.append((x,y))
    visited.add((x,y))

    while que:
        x,y = que.popleft()
        
        for nx,ny in adj_points(x,y):
            if not is_bound(nx,ny): continue
            if (nx,ny) in visited: continue
            v = board[nx][ny]
            if v >= x_val: continue

            que.append((nx,ny))
            visited.add((nx,ny))
            candidiate.append((v,nx,ny))    

    if not candidiate:
        return -1,-1
    
    candidiate.sort(key=lambda x: (-x[0],x[1],x[2]))
    nv,nx,ny = candidiate[0]
    return nx,ny


for k in range(K):
    nx,ny = move_next(x,y)
    if (nx,ny) == (x,y):
        break
    x,y = nx,ny
print(x+1,y+1)