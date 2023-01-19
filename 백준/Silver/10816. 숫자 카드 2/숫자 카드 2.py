import sys

input = sys.stdin.readline


def main():
    n = int(input())
    goal = list(map(int, input().split()))
    m = int(input())
    cards = list(map(int, input().split()))

    check = [0] * m

    def lower(num):
        left = 0
        right = n - 1
        result = -1
        while left <= right:
            mid = (left + right) // 2
            if num == goal[mid]:
                result = mid
                right = mid - 1
            elif num < goal[mid]:
                right = mid - 1
            else:
                left = mid + 1
        return result

    def upper(num):
        left = 0
        right = n - 1
        result = -1
        while left <= right:
            mid = (left + right) // 2
            if num == goal[mid]:
                result = mid
                left = mid + 1
            elif num < goal[mid]:
                right = mid - 1
            else:
                left = mid + 1
        return result

    goal.sort()

    for idx in range(m):
        low = lower(cards[idx])
        upp = upper(cards[idx])
        if low != -1:
            check[idx] = upp - low + 1

    print(*check)


main()
