N = int(input())
lines = list()
max_bound = 0
min_bound = 200000+1

for i in range(N):
    a,b = list(map(int,input().split()))
    max_bound = max(b,max_bound)
    min_bound = min(a,min_bound)
    lines.append((a,b))

overlap_cnt = [0 for _ in range(max_bound+2)]

for a, b in lines:
    overlap_cnt[a] += 1
    overlap_cnt[b] -= 1
accum_cnt = 0
max_cnt = 0
for c in overlap_cnt:
    accum_cnt += c
    max_cnt = max(accum_cnt,max_cnt)
print(max_cnt)