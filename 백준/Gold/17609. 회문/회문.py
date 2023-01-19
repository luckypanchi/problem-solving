import sys

input = sys.stdin.readline


def check(target, start, dest):
    while start <= dest:
        if target[start] != target[dest]:
            return False
        start += 1
        dest -= 1

    return True


def solve(target):
    left = 0
    right = len(target) - 1

    while left <= right:
        if target[left] == target[right]:
            left += 1
            right -= 1
        else:
            check1 = check(target, left + 1, right)
            check2 = check(target, left, right - 1)
            if check1 or check2:
                return 1
            else:
                return 2
    return 0


def main():
    tc = int(input())

    for _ in range(tc):
        target = input().strip()
        print(solve(target))


main()
