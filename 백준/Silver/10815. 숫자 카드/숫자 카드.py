import sys

input = sys.stdin.readline


def main():
    n = int(input())
    card_1 = list(map(int, input().split()))
    m = int(input())
    card_2 = list(map(int, input().split()))

    check = [0] * m

    card_1.sort()

    def find(num):
        left = 0
        right = n - 1
        while left <= right:
            mid = (left + right) // 2
            if num == card_1[mid]:
                return 1
            elif num < card_1[mid]:
                right = mid - 1
            else:
                left = mid + 1
        return 0

    for idx in range(m):
        check[idx] = find(card_2[idx])

    print(*check)


main()
