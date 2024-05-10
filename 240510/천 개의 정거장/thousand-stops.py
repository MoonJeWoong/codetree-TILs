A, B, N = list(map(int,input().split()))
graph = [[ (float('inf'),0) for _ in range(1000+1)] for _ in range(1000+1)]
dist = [ (float('inf'),0) for _ in range(1000+1)]
visited = [False for _ in range(1000+1)]
point_set = set()

for v1 in range(1,N+1):
    cost, num_point = list(map(int,input().split()))
    points = list(map(int,input().split()))
    for i in range(num_point):
        for j in range(i+1,num_point):
            v1,v2 = points[i], points[j]
            graph[v1][v2] = min((cost,j-i), graph[v1][v2])

for i in range(1,1001):
    graph[i][i] = (0,0)            

dist[A] = (0,0)

for i in range(1,1000+1):
    min_idx = -1
    for j in range(1,1000+1):
        if visited[j]: continue
        if min_idx == -1 or dist[min_idx] > dist[j]:
            min_idx = j
    visited[min_idx] = True
    min_cost, min_time = dist[min_idx]
    for j in range(1,1000+1):
        cost, time = graph[min_idx][j]
        dist[j] = min(dist[j], (min_cost + cost,min_time+time))
if dist[B][0] == float('inf'):
    print(-1,-1)
else:
    for v in dist[B]:

        print(v,end=' ')