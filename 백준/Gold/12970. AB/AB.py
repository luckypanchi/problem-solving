import sys

input = sys.stdin.readline


def main():
    n, k = map(int, input().split())

    for a in range(1, n + 1):
        b = n - a
        if a * b < k:
            continue
        count = [0] * (b + 1)
        for i in range(a):
            x = min(b, k)
            count[x] += 1
            k -= x
        for idx in range(b, -1, -1):
            for _ in range(count[idx]):
                print("A", end="")
            if idx != 0:
                print("B", end="")
        return
    print(-1)


main()
