N,M = list(map(int,input().split()))
graph = [[0 for _ in range(N+1)] for _ in range(N+1)]
for i in range(M):
    v1,v2,d = list(map(int,input().split()))
    graph[v1][v2] = d

dist = [float('inf') for _ in range(N+1)] 
visited = [False] * (N+1)
dist[1] = 0
for i in range(1,N+1):
    min_index = -1
    for j in range(1,N+1):
        if visited[j]: continue
        if min_index == -1 or dist[min_index] > dist[j]:
            min_index = j

    visited[min_index] = True

    for j in range(N+1):
        if graph[min_index][j] == 0:
            continue
        dist[j] = min(dist[j], dist[min_index] + graph[min_index][j])

for i in range(2,N+1):
    if dist[i] == float('inf'):
        print(-1)
    else:
        print(dist[i])