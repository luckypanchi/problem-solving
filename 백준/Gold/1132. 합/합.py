import sys
from collections import defaultdict

input = sys.stdin.readline


n = int(input())
counter = defaultdict(int)
noZero = []

for _ in range(n):
    s = input().strip()
    for i in range(len(s)):
        if i == 0:
            noZero.append(s[i])
        counter[s[i]] += 10 ** (len(s) - 1 - i)

zero = []
for i in "ABCDEFGHIJ":
    if i not in noZero:
        zero.append((i, counter[i]))

zero.sort(key=lambda x: x[1])
zeroChar = zero[0][0]
del counter[zeroChar]

counterList = list(counter.values())
counterList.sort(reverse=True)
answer = 0
for i in range(9):
    answer += counterList[i] * (9 - i)

print(answer)