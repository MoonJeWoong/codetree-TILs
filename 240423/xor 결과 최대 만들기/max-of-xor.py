N, M = list(map(int,input().split()))
nums = list(map(int,input().split()))

def compute_xor(nums):
    val = nums[0]
    for v in nums[1:]:
        val = val^v
    return val
def backtrack(cnt, selected):
    global max_val
    if len(selected) == M:
        val = compute_xor(selected)
        max_val = max(val, max_val)
        return
    if cnt == N: return
    v = nums[cnt]
    selected.append(v)
    backtrack(cnt+1, selected)
    selected.pop()
    backtrack(cnt+1, selected)

global max_val
max_val = 0
selected = list()
backtrack(0,selected)
print(max_val)