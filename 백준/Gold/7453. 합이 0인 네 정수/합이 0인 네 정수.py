import sys

input = sys.stdin.readline


n = int(input())
a = []
b = []
c = []
d = []
for _ in range(n):
    _a, _b, _c, _d = map(int, input().split())
    a.append(_a)
    b.append(_b)
    c.append(_c)
    d.append(_d)

ab = []
cd = []

for i in range(n):
    for j in range(n):
        ab.append(a[i] + b[j])
        cd.append(c[i] + d[j])

ab.sort()
cd.sort()

left = 0
right = n**2 - 1
answer = 0

while left < n**2 - 1 and 0 <= right:
    currSum = ab[left] + cd[right]
    if currSum == 0:
        tmpLeft = left
        tmpRight = right
        while tmpLeft < n**2 and ab[left] == ab[tmpLeft]:
            tmpLeft += 1
        while 0 <= tmpRight and cd[right] == cd[tmpRight]:
            tmpRight -= 1

        answer += (tmpLeft - left) * (right - tmpRight)
        left = tmpLeft
        right = tmpRight
    elif currSum > 0:
        right -= 1
    else:
        left += 1

print(answer)