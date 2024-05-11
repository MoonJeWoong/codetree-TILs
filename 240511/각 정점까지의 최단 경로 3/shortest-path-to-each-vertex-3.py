N, M = list(map(int,input().split()))
graph = [[0 for _ in range(N+1)] for _ in range(N+1)]

for i in range(M):
    v1,v2,w = list(map(int,input().split()))
    graph[v1][v2] = w

dist = [float('inf') for _ in range(N+1)]
visited = [False for _ in range(N+1)]
dist[1] = 0

for _ in range(N):
    min_idx = -1
    for j in range(1,N+1):
        if visited[j]: continue
        if min_idx == -1 or dist[min_idx] > dist[j]:
            min_idx = j
    visited[min_idx] = True
    
    for j in range(1,N+1):
        if graph[min_idx][j] == 0: continue
        dist[j] = min(dist[j], dist[min_idx] + graph[min_idx][j])

for i in range(2,N+1):
    if dist[i] == float('inf'):
        dist[i] = -1
    print(dist[i])