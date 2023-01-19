import sys

input = sys.stdin.readline


def main():
    h, w = map(int, input().split())
    height = list(map(int, input().split()))

    answer = 0
    for idx in range(1, w - 1):
        left_max = max(height[:idx])
        right_max = max(height[idx + 1 :])

        key = min(left_max, right_max)

        if height[idx] < key:
            answer += key - height[idx]

    print(answer)


main()
