N,M = list(map(int,input().split()))
graph = [[0 for _ in range(N+1)]for _ in range(N+1)]
for _ in range(M):
    v1,v2,d = list(map(int,input().split()))
    graph[v1][v2] = d
    graph[v2][v1] = d
dist = [float('inf') for _ in range(N+1)]
visited = [False for _ in range(N+1)]
path = [0 for _ in range(N+1)]

start, end = list(map(int,input().split()))

dist[start] = 0

for i in range(1,N+1):
    min_index = -1
    for j in range(1,N+1):
        if visited[j]: continue
        if min_index == -1 or dist[min_index] > dist[j]:
            min_index = j
    visited[min_index] = True

    for j in range(1,N+1):
        if graph[min_index][j] == 0: continue

        if dist[j] > dist[min_index] + graph[min_index][j]:
            dist[j] = dist[min_index] + graph[min_index][j]
            path[j] = min_index
print(dist[end])

x = end
nodes = list()
nodes.append(x)

while x != start:
    x = path[x]
    nodes.append(x)
for num in nodes[::-1]:
    print(num, end=' ')