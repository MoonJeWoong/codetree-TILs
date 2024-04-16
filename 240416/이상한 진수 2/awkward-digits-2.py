a = input()
data = ''
c_flag = False
for i in range(len(a)):
    if a[i] == '1':
        data += '1'
    else:        
        if c_flag:
            data += '0'
        else:
            c_flag = True
            data += '1'
if not c_flag:
    data = data[:-1] + '0'

print(int(data,2))