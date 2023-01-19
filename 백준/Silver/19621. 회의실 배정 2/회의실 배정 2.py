import sys

def main():
    n = int(sys.stdin.readline())
    matrix = list(list(map(int, sys.stdin.readline().split())) for _ in range(n))

    def dfs(arr, ans):
        stop = True
        for i in range(n):
            if matrix[i][0] > arr[1]:
                dfs(matrix[i], ans+arr[2])
                stop = False
        if stop == True: 
            answer.append(ans+arr[2])
            return
        
    answer = []
    for i in range(n):
        if matrix[i][0] > 0:
            dfs(matrix[i], 0)
    print(max(answer))



if __name__ == "__main__":
    main()