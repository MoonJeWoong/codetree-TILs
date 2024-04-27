N, M = list(map(int,input().split()))

board = [[0 for i in range(N)] for i in range(N)]
points = list()


adj_points = lambda x,y: [(x+dx,y+dy) for dx,dy in [(-1,0), (0,1), (1,0), (0,-1)]]
is_bound = lambda x,y: True if (0<=x<N and 0<=y<N) else False

def is_relax(x,y):
    cnt = 0
    for nx,ny in adj_points(x,y):
        if not is_bound(nx,ny):
            continue
        if board[nx][ny] == 1:
            cnt += 1
    return cnt == 3

for i in range(M):
    r, c = list(map(int,input().split()))
    r -= 1
    c -= 1
    board[r][c] = 1
    if is_relax(r,c):
        print(1)
    else:
        print(0)