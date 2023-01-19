import sys

input = sys.stdin.readline

answer = 0


def go(arr, goal, idx, total, curr):
    global answer
    if idx == len(arr):
        if total == goal and curr != 0:
            answer += 1
        return

    go(arr, goal, idx + 1, total + arr[idx], curr + 1)
    go(arr, goal, idx + 1, total, curr)


def main():
    n, s = map(int, input().split())
    arr = list(map(int, input().split()))

    go(arr, s, 0, 0, 0)

    print(answer)


main()
