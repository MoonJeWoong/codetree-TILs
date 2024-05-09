N, M = list(map(int,input().split()))
graph = [[0 for _ in range(N+1)] for _ in range(N+1)]
dist = [float('inf') for _ in range(N+1)]
visited = [False for _ in range(N+1)]
for _ in range(M):
    v1,v2,d = list(map(int,input().split()))
    graph[v1][v2] = d
    graph[v2][v1] = d
A, B = list(map(int,input().split()))
dist[B] = 0
for i in range(1,N+1):
    min_idx = -1
    for j in range(1,N+1):
        if visited[j]: continue
        if min_idx == -1 or dist[min_idx] > dist[j]:
            min_idx = j
    visited[min_idx] = True
    for j in range(1,N+1):
        if graph[min_idx][j] == 0: continue
        dist[j] = min(dist[j], dist[min_idx] + graph[min_idx][j])

print(dist[A])
x = A
print(x,end=' ')
while x != B:
    for i in range(1,N+1):
        if graph[i][x] == 0: continue
        if dist[i] + graph[i][x] == dist[x]:
            x = i
            break
    print(x,end=' ')