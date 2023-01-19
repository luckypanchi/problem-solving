import sys

def pArr(arr):
    for i in arr:
        print(i)

def main():
    m, n = map(int, sys.stdin.readline().split())
    matrix = [list(sys.stdin.readline().strip()) for _ in range(m)]

    answer = []
    for h in range(m-7):
        for w in range(n-7):
            tmpArr = [row[w:w+8] for row in matrix[h:h+8]]
            res = [0, 0]
            for i in range(8):
                for j in range(8):
                    if (i+j)%2:
                        if tmpArr[i][j] != 'W': res[0] += 1
                    else:
                        if tmpArr[i][j] != 'B': res[0] += 1
            for i in range(8):
                for j in range(8):
                    if (i+j)%2:
                        if tmpArr[i][j] != 'B': res[1] += 1
                    else:
                        if tmpArr[i][j] != 'W': res[1] += 1
            answer.append(min(res))
    print(min(answer))




if __name__ == "__main__":
    main()