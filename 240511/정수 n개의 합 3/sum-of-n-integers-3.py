N, K = list(map(int,input().split()))
board = list()
accum_board = [[0 for _ in range(N+1)] for _ in range(N+1)]
for i in range(1,N+1):
    line = [0] + list(map(int,input().split()))
    # print(line[1:])
    for j in range(1,N+1):
        accum_board[i][j] = accum_board[i-1][j] + accum_board[i][j-1] \
                                - accum_board[i-1][j-1] + line[j]

# for i in range(N+1):
#     print(accum_board[i])
max_val = 0

for sx in range(N):
    ex = sx + K
    if ex > N: continue
    for sy in range(N):
        ey = sy+K
        if ey > N: continue
        # print(sx,sy,'\t',ex,ey)
        val = accum_board[ex][ey] - (accum_board[sx][ey]+accum_board[ex][sy]) + accum_board[sx][sy]
        # print(val)
        # print()
        max_val = max(val,max_val)
print(max_val)