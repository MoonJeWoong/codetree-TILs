N = int(input())
board = list()

for i in range(N):
    line = list(map(int,input().split()))
    board.append(line)


popul_list = list()

from collections import deque

adj_points = lambda x,y: [(x+dx,y+dy) for dx,dy in [(-1,0), (0,1), (1,0), (0,-1)]]
is_bound = lambda x,y: True if (0<=x<N and 0<=y<N) else False

def travel_vil(x,y,color):
    que = deque()
    board[x][y] = color
    que.append((x,y))
    cnt = 1

    while que:
        x,y = que.pop()        
        
        for nx, ny in adj_points(x,y):
            if not is_bound(nx,ny): continue
            if board[nx][ny] != 1: continue
            que.append((nx,ny))
            board[nx][ny] = color
            cnt += 1
    assert cnt > 0 
    return cnt

for i in range(N):
    for j in range(N):
        p = board[i][j]
        if p != 1: continue
        color = len(popul_list)+2
        cnt = travel_vil(i,j,color)
        popul_list.append(cnt)
popul_list.sort()
print(len(popul_list))
for cnt in popul_list:
    print(cnt)