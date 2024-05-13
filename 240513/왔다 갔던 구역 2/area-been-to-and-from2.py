n = int(input())
from collections  import Counter
count = Counter()
loc = 0
# count[0] += 1
min_loc, max_loc = loc, loc
for i in range(n):
    x, D = input().split()
    if D == 'R':
        new_loc = loc + int(x)
        for i in range(loc+1, new_loc+1):
            count[i] += 1
    else:
        new_loc = loc - int(x)
        for i in range(new_loc, loc):
            count[i] += 1

    loc = new_loc
    min_loc = min(loc,min_loc)
    max_loc = max(loc,max_loc)

cnt = 0
for i in range(min_loc,max_loc+1):
    if count[i] > 1: cnt+=1
print(cnt)
# print(count)