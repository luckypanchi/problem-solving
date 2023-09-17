import sys

input = sys.stdin.readline


def solve(n, d, rules):
    left = 1
    right = n
    while left <= right:
        mid = (left + right) // 2

        cnt = 0
        for start, end, step in rules:
            if start > mid:
                continue
            if mid > end:
                cnt += (end - start) // step + 1
            else:
                cnt += (mid - start) // step + 1

            if cnt >= d:
                right = mid - 1
                answer = mid
                break
        else:
            left = mid + 1
    return answer


n, k, d = map(int, input().split())
rules = [list(map(int, input().split())) for _ in range(k)]


print(solve(n, d, rules))
