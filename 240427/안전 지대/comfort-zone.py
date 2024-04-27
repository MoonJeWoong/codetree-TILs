from collections import deque
DEBUG = True
dprint = lambda x: print(x) if DEBUG else False

N, M = list(map(int,input().split()))
max_K = 0
board = list()
for i in range(N):
    line = list(map(int,input().split()))
    board.append(line)
    max_K = max(max_K, max(line))


adj_point = lambda x,y: [(x+dx,y+dy) for dx,dy in [(-1,0),(0,1),(1,0),(0,-1)]]
is_bound = lambda x,y: True if (0<=x<N and 0<=y<M) else False

def visit_area(x,y,k,visited):
    que = deque()
    que.append((x,y))
    visited.add((x,y))
    while que:
        x,y = que.pop()
        for nx,ny in adj_point(x,y):
            if not is_bound(nx,ny):continue
            if (nx,ny) in visited: continue
            if board[nx][ny] <=k: continue
            que.append((nx,ny))
            visited.add((nx,ny))



def find_safty_area(k):
    visited = set()
    area_cnt = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] <= k: continue
            if (i,j) in visited: continue
            visit_area(i,j,k,visited)
            area_cnt += 1
    return area_cnt


area_cnt_list = list()
for K in range(1,max_K+1):
    safe_cnt = find_safty_area(K)
    area_cnt_list.append((safe_cnt,K))
area_cnt_list.sort(key=lambda x: (-x[0],x[1]))

print(area_cnt_list[0][1], area_cnt_list[0][0])