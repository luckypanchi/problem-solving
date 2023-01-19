import sys

input = sys.stdin.readline

flag = [False] * 10001


def set_flag(num):
    global flag

    result = num
    while not num < 10:
        result += num % 10
        num = num // 10
    result += num

    if result < len(flag):
        flag[result] = True


def main():
    i = 1
    for i in range(1, 10001):
        set_flag(i)
        i += 1

    for idx in range(1, 10001):
        if not flag[idx]:
            print(idx)


main()
