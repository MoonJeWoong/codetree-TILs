N = int(input())
d_matrix = list()
max_val = 0
for i in range(N):
    row = list(map(int,input().split()))
    max_val += sum(row)
    d_matrix.append(row)
global min_cost
min_cost = max_val
def backtrack(cur, visited, cost):
    if len(visited) == N:
        if cur == 0:
            global min_cost
            min_cost = min(cost, min_cost)
        return 
    
    row = d_matrix[cur]

    for i, d in enumerate(row):
        if i in visited or i == cur: continue
        if d == 0: continue
        visited.append(i)
        backtrack(i,visited, cost+d)
        visited.pop()
visited = list()
backtrack(0,visited,0)
print(min_cost)