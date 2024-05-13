T, a, b =list(map(int,input().split()))
s_list = list()
n_list = list()

for i in range(T):
    v, num = input().split()
    if v == 'S': 
        s_list.append(int(num))
    else:
        n_list.append(int(num))


def near(arr,i):
    return min([abs(a-i) for a in arr]) 
cnt =0 
for i in range(a,b+1):
    d1 = near(s_list,i)
    d2 = near(n_list,i)
    if d1 <= d2:
        cnt += 1
print(cnt)