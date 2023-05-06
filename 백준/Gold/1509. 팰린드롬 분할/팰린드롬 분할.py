import sys

input = sys.stdin.readline

INF = float("inf")


string = input().strip()
length = len(string)
check = [[False] * length for _ in range(length)]

for i in range(length):
    check[i][i] = True

for i in range(length - 1):
    if string[i] == string[i + 1]:
        check[i][i + 1] = True

for _len in range(3, length + 1):
    for start in range(length - _len + 1):
        end = start + _len - 1
        if string[start] == string[end] and check[start + 1][end - 1]:
            check[start][end] = True


dp = [0] * length
dp[0] = 1
for end in range(1, length):
    dp[end] = dp[end - 1] + 1
    for start in range(end):
        if check[start][end]:
            if start == 0:
                dp[end] = 1
                break
            else:
                dp[end] = min(dp[end], dp[start - 1] + 1)

print(dp[-1])