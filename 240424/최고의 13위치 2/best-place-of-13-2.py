N = int(input())
board = list()
for i in range(N):
    line = list(map(int,input().split()))
    board.append(line)

def count_coin(p1,p2):
    x,y = p1
    cnt = board[x][y] + board[x][y+1] + board[x][y+2]
    x,y = p2
    cnt += board[x][y] + board[x][y+1] + board[x][y+2]
    return cnt
max_cnt=0
for i in range(N):
    for j in range(N-2):
        p1 = (i,j)
        for k in range(N):
            if k == i:
                for l in range(j+3,N-2):
                    p2 = (k,l)
                    # print(p1,p2)
                    cnt = count_coin(p1,p2)
                    max_cnt = max(cnt, max_cnt)
            else:
                for l in range(N-2):
                    p2 = (k,l)
                    # print(p1,p2)
                    cnt = count_coin(p1,p2)
                    max_cnt = max(cnt, max_cnt)  
print(max_cnt)