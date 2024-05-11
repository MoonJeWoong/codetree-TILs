N, M = list(map(int,input().split()))
board = list()

for i in range(N):
    line = list(map(int,input().split()))
    board.append(line)
visited = [[False for i in range(M)] for _ in range(N)]

def next_points(x,y):
    px,py = x+1, y
    if (0<=px<N) and (0<=py<M) and board[px][py] == 1 and not visited[px][py]:
        yield px,py
    px,py = x, y+1
    if (0<=px<N) and (0<=py<M) and board[px][py] == 1 and not visited[px][py]:
        yield px,py

from collections import deque
global can_go
can_go = 0
def bfs(s,e):
    global can_go
    que = deque()
    x,y = s
    que.append((x,y))
    visited[x][y] = True

    while que:
        cur = que.popleft()
        if e == cur:
            can_go = 1
            return 
        x, y = cur
        for nx,ny in next_points(x,y):
            visited[nx][ny] = True
            que.append((nx,ny))


bfs((0,0), (N-1,M-1))
print(can_go)