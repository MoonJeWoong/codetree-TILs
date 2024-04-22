N = int(input())

points = list()
for i in range(N):
    x, y = list(map(int,input().split()))
    points.append((x,y))

points.sort()

min_val = 1000
for b in range(0,1001,2):
    cnt = [0,0,0,0]

    for x, y in points:
        if y > b:
            cnt[0] += 1
        else:
            cnt[3] += 1 
    # min_val = min(min_val,max(cnt))
    for i, (x, y) in enumerate(points):
        if i == 0 or x != points[i-1][0]:
            min_val = min(min_val,max(cnt))
        if y > b:
            cnt[0] -= 1
            cnt[1] += 1
        else:
            cnt[3] -=1
            cnt[2] += 1
        
 
    # min_val = min(min_val,max(cnt))
print(min_val)