def solution(n, build_frame):
    columns = [[0] * (n + 4) for _ in range(n + 4)]
    beams = [[0] * (n + 4) for _ in range(n + 4)]

    for x, y, a, b in build_frame:
        x += 2
        y += 2

        if a == 0:  # 기둥
            if b == 0:  # 삭제
                columns[x][y] = 0
                if not check(columns, beams, n + 4):
                    columns[x][y] = 1

            else:  # 설치
                columns[x][y] = 1
                if not check(columns, beams, n + 4):
                    columns[x][y] = 0

        else:  # 보
            if b == 0:  # 삭제
                beams[x][y] = 0
                if not check(columns, beams, n + 4):
                    beams[x][y] = 1

            else:  # 설치
                beams[x][y] = 1
                if not check(columns, beams, n + 4):
                    beams[x][y] = 0

    answer = []
    for i in range(n + 4):
        for j in range(n + 4):
            if columns[i][j] == 1:
                answer.append([i - 2, j - 2, 0])

    for i in range(n + 4):
        for j in range(n + 4):
            if beams[i][j] == 1:
                answer.append([i - 2, j - 2, 1])

    answer.sort(key=lambda x: (x[0], x[1], x[2]))

    return answer


def check(columns, beams, n):
    for x in range(n):
        for y in range(n):
            if columns[x][y] == 1:
                if not (
                    y == 2
                    or beams[x][y] == 1
                    or beams[x - 1][y] == 1
                    or columns[x][y - 1] == 1
                ):
                    return False
            if beams[x][y] == 1:
                if not (
                    columns[x][y - 1] == 1
                    or columns[x + 1][y - 1] == 1
                    or (beams[x - 1][y] == 1 and beams[x + 1][y] == 1)
                ):
                    return False

    return True