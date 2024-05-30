import sys

input = sys.stdin.readline


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


n = int(input())
numbers = [0] + list(map(int, input().split())) + [0]
prefixGcd = [0] * (n + 2)
suffixGcd = [0] * (n + 2)

prefixGcd[1] = numbers[1]
suffixGcd[n] = numbers[n]

for i in range(1, n + 1):
    j = n - i + 1
    prefixGcd[i] = gcd(prefixGcd[i - 1], numbers[i])
    suffixGcd[j] = gcd(suffixGcd[j + 1], numbers[j])

answers = []
for i in range(1, n + 1):
    left = prefixGcd[i - 1]
    right = suffixGcd[i + 1]

    result = gcd(left, right)
    if numbers[i] % result != 0:
        answers.append((result, numbers[i]))

answers.sort(key=lambda x: -x[0])
if len(answers) == 0:
    print(-1)
else:
    print(*answers[0])