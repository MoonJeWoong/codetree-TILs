N, T = list(map(int,input().split()))
move_order = input()
board = list()
for i in range(N):
    line = list(map(int,input().split()))
    board.append(line)
dir_map = {0: (-1,0),1: (0,1), 2: (1,0), 3: (0,-1)}
next_point = lambda x,y,d: (x+dir_map[d][0],y+dir_map[d][1])
is_bound = lambda x,y: True if (0<=x<N and 0<=y<N) else False  


x,y,d = N//2, N//2, 0
point = board[x][y]

for m in move_order:
    # print(m,x,y,d,'\t',point)
    if m == 'L':
        d = d-1 if d>0 else 3
    elif m == 'R':
        d = d+1 if d<3 else 0
    elif m == 'F':
        nx, ny = next_point(x,y,d)
        if not is_bound(nx,ny):
            continue
        point += board[nx][ny]
        x,y = nx, ny
    else:
        assert False
print(point)