import sys
from collections import defaultdict

input = sys.stdin.readline
MOD = 900528


letters = list(input().strip())
code = list(input().strip())
length = len(letters)

dic = defaultdict(int)
for i, letter in enumerate(letters):
    dic[letter] = i + 1

answer = 0
for i, c in enumerate(code):
    answer *= length
    answer += dic[c]
    answer %= MOD

print(answer)