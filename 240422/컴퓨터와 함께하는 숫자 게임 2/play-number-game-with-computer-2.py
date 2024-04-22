M = int(input())
a, b = list(map(int,input().split()))

min_cnt = M
max_cnt = 0

def bs_cnt(left,right,target):
    cnt = 0
    while left <= right:
        cnt += 1
        mid = (left+right)//2
        if mid == target:
            return cnt
        elif mid < target:
            left = mid + 1
        else:
            right = mid -1
        
    return cnt



for v in range(a,b+1):
    cnt = bs_cnt(1,M,v)
    # print(v,cnt)
    min_cnt = min(min_cnt, cnt)
    max_cnt = max(max_cnt, cnt)

print(min_cnt,max_cnt)