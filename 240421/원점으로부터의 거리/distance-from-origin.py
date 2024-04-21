N = int(input())

points = list()
for idx in range(N):
    x,y = list(map(int,input().split()))
    d = abs(x) + abs(y)
    points.append((x,y,idx+1, d))
points.sort(key= lambda x: (x[3], x[2]))

for _,_, idx, _ in points:
    print(idx)