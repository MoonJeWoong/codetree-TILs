N, K = list(map(int,input().split()))
bomb_nums = list()
for i in range(N):
    num = int(input())
    bomb_nums.append((num,i))
bomb_cnt = dict()

max_val = -1
for num, i in bomb_nums:
    if num in bomb_cnt and bomb_cnt[num] > 0 :
        max_val = max(num, max_val)
    else: 
        
        for n in bomb_cnt.keys():
            bomb_cnt[n] -= 1
        bomb_cnt[num] = K
print(max_val)