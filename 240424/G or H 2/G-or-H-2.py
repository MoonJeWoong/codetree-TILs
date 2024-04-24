N = int(input())
line = list()
for i in range(N):
    loc, alphabet = input().split()
    line.append((int(loc),alphabet))
line.sort()
def count_point(l,r):
    g_cnt = 0
    h_cnt = 0
    for p, a in line[l:r+1]:
        if a == 'G': g_cnt +=1
        if a == 'H': h_cnt += 1
    if g_cnt == 0 or h_cnt == 0 or g_cnt == h_cnt:
        return  line[r][0] - line[l][0]
    return 0

max_cnt = 0
# print(line)
for left in range(N):
    for right in range(left+1,N):
        cnt = count_point(left,right)
        # print(left, right)
        # print(cnt)
        # print()
        max_cnt = max(cnt,max_cnt)
print(max_cnt)