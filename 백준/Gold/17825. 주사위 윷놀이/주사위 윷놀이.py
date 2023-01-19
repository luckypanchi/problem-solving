import sys

input = sys.stdin.readline


def main():
    moves = list(map(int, input().split()))
    matrix = [
        [x for x in range(40) if x % 2 == 0],
        [10, 13, 16, 19],
        [20, 22, 24],
        [30, 28, 27, 26],
        [25, 30, 35, 40],
    ]
    horses = [(0, 0), (0, 0), (0, 0), (0, 0)]

    answer = 0

    def solve(cnt, SUM, status):
        nonlocal answer
        if cnt == 10:
            answer = max(answer, SUM)
            return

        move = moves[cnt]

        for i in range(4):
            tmp = status[i]
            if status[i] is not False:
                route, curr = status[i]

                if curr + move < len(matrix[route]):
                    if route == 0 and matrix[0][curr + move] in (10, 20, 30):
                        tmp_status = (matrix[0][curr + move] // 10, 0)
                    else:
                        tmp_status = (route, curr + move)
                    if tmp_status not in status:
                        status[i] = tmp_status
                        solve(cnt + 1, SUM + matrix[route][curr + move], status)

                elif route != 4:
                    if (route == 0 and curr + move < len(matrix[route]) + 1):
                        tmp_status = (4, 3)
                        if tmp_status not in status:
                            status[i] = tmp_status
                            solve(cnt + 1, SUM + matrix[4][3], status)
                    elif route != 0 and curr + move < len(matrix[route]) + 4:
                        tmp_status = (4, curr + move - len(matrix[route]))
                        if tmp_status not in status:
                            status[i] = tmp_status
                            solve(
                                cnt + 1,
                                SUM + matrix[4][curr + move - len(matrix[route])],
                                status,
                            )
                else:
                    status[i] = False
                    solve(cnt + 1, SUM, status)
            status[i] = tmp

    solve(0, 0, horses)

    print(answer)


main()
