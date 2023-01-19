import sys

def main():
    m, n = map(int, sys.stdin.readline().split())
    matrix = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]

    candidates = []

    for i in range(m):
        for j in range(n):
            if j+3<n: candidates.append(matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] + matrix[i][j+3])
            if i+3<m: candidates.append(matrix[i][j] + matrix[i+1][j] + matrix[i+2][j] + matrix[i+3][j])
            if i+1<m and j+1<n: candidates.append(matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1])
            if j+2<n:
                if i+1<m:
                    candidates.append(matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] + matrix[i+1][j])
                    candidates.append(matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] + matrix[i+1][j+1])
                    candidates.append(matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] + matrix[i+1][j+2])
                if i-1>=0:
                    candidates.append(matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] + matrix[i-1][j])
                    candidates.append(matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] + matrix[i-1][j+1])
                    candidates.append(matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] + matrix[i-1][j+2])
            if i+2<m:
                if j+1<n:  
                    candidates.append(matrix[i][j] + matrix[i+1][j] + matrix[i+2][j] + matrix[i][j+1])
                    candidates.append(matrix[i][j] + matrix[i+1][j] + matrix[i+2][j] + matrix[i+1][j+1])
                    candidates.append(matrix[i][j] + matrix[i+1][j] + matrix[i+2][j] + matrix[i+2][j+1])
                if j-1>=0:
                    candidates.append(matrix[i][j] + matrix[i+1][j] + matrix[i+2][j] + matrix[i][j-1])
                    candidates.append(matrix[i][j] + matrix[i+1][j] + matrix[i+2][j] + matrix[i+1][j-1])
                    candidates.append(matrix[i][j] + matrix[i+1][j] + matrix[i+2][j] + matrix[i+2][j-1])
            if i+1<m and j+2<n:
                candidates.append(matrix[i][j+1] + matrix[i][j+2] + matrix[i+1][j] + matrix[i+1][j+1])
                candidates.append(matrix[i][j] + matrix[i][j+1] + matrix[i+1][j+1] + matrix[i+1][j+2])
            if i+2<m and j+1<n:
                candidates.append(matrix[i][j] + matrix[i+1][j] + matrix[i+1][j+1] + matrix[i+2][j+1])
                candidates.append(matrix[i][j+1] + matrix[i+1][j+1] + matrix[i+1][j] + matrix[i+2][j])

    print(max(candidates))


if __name__ == "__main__":
    main()