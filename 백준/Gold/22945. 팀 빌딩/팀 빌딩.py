import sys

input = sys.stdin.readline


n = int(input())
devs = list(map(int, input().split()))

answer = 0
start = 0
end = n - 1
while start + 1 < end:
    answer = max(answer, (end - start - 1) * min(devs[start], devs[end]))
    if devs[start] < devs[end]:
        start += 1
    else:
        end -= 1

print(answer)