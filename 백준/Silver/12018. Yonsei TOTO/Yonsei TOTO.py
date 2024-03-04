import sys

input = sys.stdin.readline


n, m = map(int, input().split())
required = []
for _ in range(n):
    p, limit = map(int, input().split())
    miles = sorted(list(map(int, input().split())), reverse=True)
    if len(miles) < limit:
        required.append(1)
    else:
        required.append(miles[limit - 1])

required.sort()
answer = 0
total = 0
for mile in required:
    if total + mile <= m:
        total += mile
        answer += 1
    else:
        break

print(answer)