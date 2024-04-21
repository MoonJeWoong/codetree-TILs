N = int(input())
data = list(map(int,input().split()))
data.sort()

max_val = data[0]
for i in range(N):
    val = data[i] + data[2*N-1-i]
    max_val = max(val,max_val)
print(max_val)