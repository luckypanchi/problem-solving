import sys

input = sys.stdin.readline


n, k, b = map(int, input().split())
brokenLights = [False] * (n + 1)
for _ in range(b):
    light = int(input())
    brokenLights[light] = True

start = 1
end = 1
count = int(brokenLights[1])
answer = n

while end < n + 1:
    currLength = end - start + 1
    if currLength <= k:
        if currLength == k:
            answer = min(answer, count)
        end += 1
        if end < n and brokenLights[end]:
            count += 1
    else:
        if brokenLights[start]:
            count -= 1
        start += 1

print(answer)