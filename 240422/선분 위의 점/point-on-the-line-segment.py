n, m = list(map(int,input().split()))
points = list(map(int,input().split()))
points.sort()


def upper(target):
    left, right = 0, n-1
    min_idx = n
    while left <= right:
        mid = (left+right) // 2
        if points[mid] > target:
            right = mid-1
            min_idx = min(min_idx, mid)
        else:
            left = mid + 1
    return min_idx

def lower(target):
    left, right = 0, n-1
    min_idx = n
    while left <= right:
        mid = (left+right) // 2
        if points[mid] >= target:
            right = mid -1
            min_idx = min(min_idx,mid)
        else:
            left = mid +1
    return min_idx
    
for _ in range(m):
    a,b = list(map(int,input().split()))
    count = upper(b) - lower(a)
    print(count)