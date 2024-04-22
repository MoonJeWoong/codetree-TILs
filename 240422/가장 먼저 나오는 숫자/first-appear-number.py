n, m = list(map(int,input().split()))
nums = list(map(int,input().split()))
query = list(map(int,input().split()))

first_map = dict()
for i,n in enumerate(nums):
    if n in first_map: continue
    first_map[n] = i +1

for q in query:
    if q not in first_map:
        print(-1)
    else:
        print(first_map[q])