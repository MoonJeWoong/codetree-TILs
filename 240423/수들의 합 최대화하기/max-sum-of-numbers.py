N = int(input())
board = list()
for i in range(N):
    line = list(map(int,input().split()))
    board.append(line)


global max_val
max_val = 0

def backtrack(cnt,used,val):
    if cnt == N:
        global max_val 
        max_val = max(val, max_val)
        return 
    
    line = board[cnt]

    for i in range(N):
        if i in used: continue
        v = line[i]
        used.append(i)
        backtrack(cnt+1, used, val+v)
        used.pop()
used = list()
backtrack(0,used, 0)
print(max_val)