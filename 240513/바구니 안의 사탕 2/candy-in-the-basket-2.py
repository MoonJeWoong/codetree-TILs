N, K = list(map(int,input().split()))
DEBUG = True
dprint = lambda txt: print(txt) if DEBUG else None


buckets = [0 for _ in range(100+1)]

min_idx, max_idx = float('inf'), 0
for i in range(N):
    num_candy, b_idx  = list(map(int,input().split()))
    min_idx = min(b_idx,min_idx)
    max_idx = max(b_idx,max_idx)
    buckets[b_idx] += num_candy


i = min_idx -1
candy_sum = sum([ buckets[j] for j in range(i-K,i+K+1) if 0<=j<=100 ])
max_sum = candy_sum
for i in range(min_idx,max_idx+1):
    candy_sum += -(buckets[i-K-1] if i-K-1 >=0 else 0 ) + (buckets[i+K] if i+K <=100 else 0 )
    max_sum = max(candy_sum,max_sum)
print(max_sum)