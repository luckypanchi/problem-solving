import sys

input = sys.stdin.readline


def main():
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    answer = []

    idx_a = 0
    idx_b = 0

    for _ in range(n + m):
        if idx_a < n and idx_b < m:
            if a[idx_a] < b[idx_b]:
                answer.append(a[idx_a])
                idx_a += 1
            else:
                answer.append(b[idx_b])
                idx_b += 1
        elif idx_a < n:
            answer.append(a[idx_a])
            idx_a += 1
        else:
            answer.append(b[idx_b])
            idx_b += 1

    print(*answer)


main()
