N = int(input())


def is_beauty(arr):
    val, cnt = None, None 
    for v in arr:
        if val is None:
            val = v
            cnt = 1
            continue
        if v != val:
            if val == cnt:
                val = v
                cnt = 1
            else:
                return False
        else:
            if val == cnt:
                cnt = 0
            cnt += 1
                
    if val==cnt or cnt == 0: return True
    return False
global b_cnt 
b_cnt = 0
def backtrack(n, arr):
    global b_cnt 
    if n == N:
        if is_beauty(arr):
            b_cnt += 1
        return None
    for i in range(1,5):
        arr.append(i)
        backtrack(n+1,arr)
        arr.pop()
backtrack(0,list())
print(b_cnt)