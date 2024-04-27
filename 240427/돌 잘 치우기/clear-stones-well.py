N,K,M = list(map(int,input().split()))
board = list()

stones = list()
for i in range(N):
    line = list(map(int,input().split()))
    for j in range(N):
        if line[j] == 1:
            stones.append((i,j))
    board.append(line)

start_points = list()
for i in range(K):
    r,c = list(map(int,input().split()))
    start_points.append((r-1,c-1))
from itertools import combinations

adj_points = lambda x,y: [(x+dx,y+dy) for dx,dy in [(-1,0),(0,1),(1,0),(0,-1)]]
is_bound = lambda x,y: True if (0<=x<N and 0<=y<N) else False

def count_movable(points):
    visited = set(points)
    # stack = [ p for p in points]
    stack = list()
    stack.extend(points)

    while stack:
        x,y = stack.pop()
        for nx,ny in adj_points(x,y):
            if not is_bound(nx,ny): continue
            if (nx,ny) in visited: continue
            if board[nx][ny] == 1: continue
            
            visited.add((nx,ny))
            stack.append((nx,ny))
    return len(visited)



max_num = 0

for rm_stones in combinations(stones, M):
    # rm stones
    for sx,sy in rm_stones: board[sx][sy] = 0
    
    num = count_movable(start_points)
    max_num = max(num,max_num)
    # reset
    for sx,sy in rm_stones: board[sx][sy] = 1

print(max_num)