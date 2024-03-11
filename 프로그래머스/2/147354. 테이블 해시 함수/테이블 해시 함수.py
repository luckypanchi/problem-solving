def solution(data, col, row_begin, row_end):
    data.sort(key=lambda x: (x[col - 1], -x[0]))
    s = [0] * (len(data) + 1)
    for i in range(len(data)):
        for j in range(len(data[0])):
            s[i + 1] += data[i][j] % (i + 1)

    answer = s[row_begin]
    for i in range(row_begin + 1, row_end + 1):
        answer ^= s[i]
    return answer