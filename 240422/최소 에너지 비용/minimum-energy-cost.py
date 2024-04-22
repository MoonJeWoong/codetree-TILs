N = int(input())
use_energy = [0] + list(map(int,input().split()))
fill_time = list(map(int,input().split()))

min_cost = [None] * N
min_cost[0] = fill_time[0] 
for i, (e, cost) in enumerate(zip(use_energy,fill_time)):
    if i == 0: continue
    min_cost[i] = min(min_cost[i-1], cost)
# print(min_cost)
ans = 0
for i, v in enumerate(use_energy[1:]):
    ans += v*min_cost[i]
print(ans)