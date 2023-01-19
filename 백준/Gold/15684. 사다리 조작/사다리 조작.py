import sys
input = sys.stdin.readline
import itertools

def pArr(arr):
    for i in arr:
        print(i)

def main():
    n, m, h = map(int, input().split())

    matrix = [[0]*(2*n+1) for _ in range(2*h+1)]
    tmp = []

    for i in range(1, 2*h):
        for j in range(1, 2*n):
            if i%2 and not j%2: tmp.append((i, j))    

    for _ in range(m):
        y, x = map(int, input().split())
        matrix[2*y-1][2*x] = 1
        tmp.remove((2*y-1, 2*x))
        if (2*y-1, 2*x-2) in tmp: tmp.remove((2*y-1, 2*x-2))
        if (2*y-1, 2*x+2) in tmp: tmp.remove((2*y-1, 2*x+2))
    
    candidates = []
    for i in range(4):
        candidates += list(itertools.combinations(tmp, i))

    for j in range(2*n):
        for i in range(2*h):
            if j%2: matrix[i][j] = 1

    def ladder(start):
        dest = start
        for i in range(2*h):
            if matrix[i][dest+1] == 1: dest += 2
            elif matrix[i][dest-1] == 1 : dest -= 2
        return start == dest

    def check():        
        isTrue = True
        for i in range(2*n+1):
            if i%2 and not ladder(i):
                isTrue = False
                break
        if isTrue: return True
    
    result = -1
    for tmp in candidates:
        for arr in tmp:
            y, x = arr
            matrix[y][x] = 1
        
        if check():
            result = len(tmp)
            break

        for arr in tmp:
            y, x = arr
            matrix[y][x] = 0

    print(result)


if __name__ == "__main__":
    main()