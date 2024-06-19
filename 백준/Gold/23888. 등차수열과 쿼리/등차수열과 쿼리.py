import sys

input = sys.stdin.readline


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


a, d = map(int, input().split())
tc = int(input())
for _ in range(tc):
    q, l, r = map(int, input().split())
    if q == 1:
        answer = r * (2 * a + (r - 1) * d) // 2 - (l - 1) * (2 * a + (l - 2) * d) // 2
    elif q == 2:
        if r - l + 1 == 1:
            answer = a + (r - 1) * d
        elif (r - l + 1) % 2 == 0:
            answer = gcd(a, d)
        else:
            answer = gcd(a + (r - 1) * d, gcd(a, d))

    print(answer)