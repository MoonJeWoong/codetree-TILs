N, K = list(map(int,input().split()))
nums = list(map(int,input().split()))
from collections import Counter
counter = Counter(nums)
results = list()

for k,v in counter.items():
    results.append((k,v))

results.sort(key=lambda x:(-x[1],-x[0]))

for i in range(K):
    print(results[i][0], end=' ')