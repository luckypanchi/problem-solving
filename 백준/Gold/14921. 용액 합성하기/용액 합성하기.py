import sys

input = sys.stdin.readline

INF = float("inf")


n = int(input())
liquids = sorted(list(map(int, input().split())))

answer = -1
diff = INF

left = 0
right = n - 1

while left < right:
    s = liquids[left] + liquids[right]
    if s == 0:
        answer = s
        diff = 0
        break
    elif s < 0:
        left += 1
    else:
        right -= 1

    if abs(s) < diff:
        diff = abs(s)
        answer = s

print(answer)