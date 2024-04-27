from collections import deque
DEBUG = True
dprint = lambda x: print(x) if DEBUG else False

N, M = list(map(int,input().split()))
max_k = 0
board = list()
for i in range(N):
    line = list(map(int,input().split()))
    board.append(line)
    max_k = max(max_k, max(line))


adj_point = lambda x,y: [(x+dx,y+dy) for dx,dy in [(-1,0),(0,1),(1,0),(0,-1)]]
is_bound = lambda x,y: True if (0<=x<N and 0<=y<M) else False

def visit_area(x,y,k,gvisited):
    que = deque()
    visited = set()
    que.append((x,y))
    visited.add((x,y))
    while que:
        x,y = que.pop()
        for nx,ny in adj_point(x,y):
            if not is_bound(nx,ny):continue
            if (nx,ny) in visited.union(gvisited): continue
            if board[nx][ny] <=k: continue
            que.append((nx,ny))
            visited.add((nx,ny))
    return visited



def find_safty_area(k):
    global_visited = set()
    area_cnt = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] <= k: continue
            if (i,j) in global_visited: continue
            visited = visit_area(i,j,k,global_visited)
            area_cnt += 1
            global_visited.update(visited)
    return area_cnt


area_cnt_list = list()
for K in range(1,max_k+1):
    safe_cnt = find_safty_area(K)
    area_cnt_list.append((safe_cnt,K))
area_cnt_list.sort(key=lambda x: (-x[0],x[1]))

print(area_cnt_list[0][1], area_cnt_list[0][0])