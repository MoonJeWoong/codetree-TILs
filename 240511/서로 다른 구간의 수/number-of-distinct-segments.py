N = int(input())
low_bound = float('inf')
up_bound = 0
lines = list()

for i in range(N):
    a,b = list(map(int,input().split()))
    low_bound = min(a, low_bound)
    up_bound = max(b,up_bound)
    lines.append((a,b))

overlap_arr = [0 for _ in range(up_bound+1)]

for a,b in lines:
    overlap_arr[a] += 1
    overlap_arr[b] -= 1
num_line = 1
for i in range(low_bound, up_bound):
    overlap_arr[i] = overlap_arr[i] + overlap_arr[i-1]
    if overlap_arr[i] == 0 and overlap_arr[i-1] != 0:
        num_line += 1
print(num_line)