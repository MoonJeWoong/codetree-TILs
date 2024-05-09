N, M = list(map(int,input().split()))
dist = [[float('inf') for _ in range(N+1)] for _ in range(N+1)]
for i in range(M):
    v1, v2, d = list(map(int,input().split()))
    dist[v1][v2] = min(d,dist[v1][v2])
    # dist[v2][v1] = min(d,dist[v2][v1])

for i in range(1,N+1):
    dist[i][i] = 0

for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            dist[i][j] = min(dist[i][j], dist[i][k]+dist[k][j])


for i in range(1,N+1):
    for j in range(1,N+1):
        v = dist[i][j] 
        if dist[i][j] == float('inf'): v = -1
        print(v,end=' ')
    print()