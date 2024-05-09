N = int(input())
has_edgs = [[False for _ in range(N+1)]for _ in range(N+1)]
for i in range(N):
    line = list(map(int,input().split()))
    for j in range(N):
        if line[j] == 1:
            has_edgs[i+1][j+1] = True
for i in range(1,N+1):
    has_edgs[i][i] = True

for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            if has_edgs[i][k] and has_edgs[k][j]:
                has_edgs[i][j] = True

for i in range(1,N+1):
    for j in range(1,N+1):
        if has_edgs[i][j]:
            print(1,end=' ')
        else:
            print(0,end=' ')
    print()