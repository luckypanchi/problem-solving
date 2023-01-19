import sys

input = sys.stdin.readline
INF = int(1e9)


n = list(input().rstrip())

_max = -INF
_min = INF


def count(array):
    cnt = 0
    for num in array:
        if int(num) % 2 == 1:
            cnt += 1
    return cnt


def go(number, cnt):
    global _max, _min

    cnt += count(number)

    if len(number) == 1:
        _max = max(_max, cnt)
        _min = min(_min, cnt)
        return

    elif len(number) == 2:
        new_number = list(str(int(number[0]) + int(number[1])).strip())
        return go(new_number, cnt)

    elif len(number) >= 3:
        for i in range(1, len(number) - 1):
            for j in range(i + 1, len(number)):
                new_number = list(
                    str(
                        int("".join(number[:i]))
                        + int("".join(number[i:j]))
                        + int("".join(number[j:]))
                    ).strip()
                )
                go(new_number, cnt)
        return


go(n, 0)
print(_min, _max)
