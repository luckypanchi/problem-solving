import sys

input = sys.stdin.readline


def main():
    target = list(map(int, input().strip()))

    flag = 1
    for num in target:
        if num == 0:
            flag = 0
            break

    if flag or sum(target) % 3 != 0:
        print(-1)
    else:
        target.sort(reverse=True)
        target = map(str, target)
        print("".join(target))


main()
