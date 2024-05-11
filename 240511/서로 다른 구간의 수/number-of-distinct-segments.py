N = int(input())
low_bound = float('inf')
up_bound = 0
lines = list()
points = list()
for i in range(N):
    a,b = list(map(int,input().split()))
    points.append((a,1,i))
    points.append((b,-1,i))

points.sort()

cnt = 0
curr_point = set()
for point in points:
    num, flag, idx = point
    if flag == -1:
        curr_point.remove(idx)
    elif flag == 1:
        if not curr_point: cnt += 1
        curr_point.add(idx)

print(cnt)