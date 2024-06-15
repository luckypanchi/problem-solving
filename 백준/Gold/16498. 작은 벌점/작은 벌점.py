import sys

input = sys.stdin.readline

INF = float("inf")


def find(arr, target):
    left = 0
    right = len(arr) - 1
    result = 0

    while left <= right:
        mid = (left + right) // 2
        if arr[mid] <= target:
            result = mid
            left = mid + 1
        else:
            right = mid - 1

    if result + 1 < len(arr) and abs(target - arr[result + 1]) < abs(target - arr[result]):
        return arr[result + 1]

    return arr[result]


a, b, c = map(int, input().split())
card1 = sorted(list(map(int, input().split())))
card2 = sorted(list(map(int, input().split())))
card3 = sorted(list(map(int, input().split())))

answer = INF

for c1 in card1:
    c2 = find(card2, c1)
    c3_1 = find(card3, c1)
    c3_2 = find(card3, c2)
    answer = min(
        answer, max(c1, c2, c3_1) - min(c1, c2, c3_1), max(c1, c2, c3_2) - min(c1, c2, c3_2)
    )

print(answer)