import sys

input = sys.stdin.readline


def add(string, path, cnt):
    return string + path * cnt


def main():
    r, c = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(r)]

    answer = ""
    y1, x1 = 0, 0
    y2, x2 = r - 1, c - 1

    if r % 2 == 1:
        while y1 != r - 1:
            answer = add(answer, "R", c - 1)
            answer = add(answer, "D", 1)
            answer = add(answer, "L", c - 1)
            answer = add(answer, "D", 1)
            y1 += 2
        answer = add(answer, "R", c - 1)
    elif c % 2 == 1:
        while x1 != c - 1:
            answer = add(answer, "D", r - 1)
            answer = add(answer, "R", 1)
            answer = add(answer, "U", r - 1)
            answer = add(answer, "R", 1)
            x1 += 2
        answer = add(answer, "D", r - 1)
    else:
        tmp = ""
        min_num = 9999
        min_y = 0
        min_x = 0
        for i in range(r):
            for j in range(c):
                if ((i + j) % 2 == 1) and (matrix[i][j] < min_num):
                    min_num = matrix[i][j]
                    min_y = i
                    min_x = j

        while min_y - y1 > 1:
            answer = add(answer, "R", c - 1)
            answer = add(answer, "D", 1)
            answer = add(answer, "L", c - 1)
            answer = add(answer, "D", 1)
            y1 += 2
        while y2 - min_y > 1:
            tmp = add(tmp, "R", c - 1)
            tmp = add(tmp, "D", 1)
            tmp = add(tmp, "L", c - 1)
            tmp = add(tmp, "D", 1)
            y2 -= 2
        while min_x - x1 > 1:
            answer = add(answer, "D", 1)
            answer = add(answer, "R", 1)
            answer = add(answer, "U", 1)
            answer = add(answer, "R", 1)
            x1 += 2
        while x2 - min_x > 1:
            tmp = add(tmp, "D", 1)
            tmp = add(tmp, "R", 1)
            tmp = add(tmp, "U", 1)
            tmp = add(tmp, "R", 1)
            x2 -= 2
        if x1 + 1 == min_x and y1 == min_y:
            answer = add(answer, "D", 1)
            answer = add(answer, "R", 1)
        else:
            answer = add(answer, "R", 1)
            answer = add(answer, "D", 1)

        answer += "".join(reversed(tmp))

    print(answer)


main()
