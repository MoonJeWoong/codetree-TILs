data = input()
size = len(data)

close_num = [0 for _ in range(size)]

for i in range(size-2,-1,-1):
    if data[i] == ')' and data[i] == data[i+1]:
        close_num[i] += 1
    close_num[i] += close_num[i+1]
# print(close_num)
cnt = 0
for i in range(size-1):
    if data[i] == '(' and data[i] == data[i+1]:
        cnt += close_num[i]
print(cnt)