import sys

input = sys.stdin.readline


def main():
    m, n, k = map(int, input().split())

    if m % 2 != 0:
        m -= 1
        k -= 1

    if 2 * n < m:
        diff = m - 2 * n
        k -= diff
        m -= diff
    elif m < 2 * n:
        diff = n - m // 2
        k -= diff
        n -= diff

    if k <= 0:
        print(n)
        return

    while k > 0:
        m -= 2
        n -= 1
        k -= 3

    if m // 2 == n:
        print(n)
    else:
        print(0)


main()
