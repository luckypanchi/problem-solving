import sys

def main():
    day = int(sys.stdin.readline())
    matrix = [[]]
    for i in range(day):
        a, b = map(int, sys.stdin.readline().split())
        matrix.append([a, b])

    payment = []

    def dfs(cur, total):        
        pay = total + matrix[cur][1]    
        stop = True
        
        for i in range(cur + matrix[cur][0], day+1):
            if i + matrix[i][0] - 1 < day+1:
                dfs(i, pay)
                stop = False
        
        if stop == True:
            payment.append(pay)

    for i in range(1, day+1):
        if i + matrix[i][0] - 1 < day+1:
            dfs(i, 0)

    if payment:                                     # 진짜 치사하다
        print(max(payment))
    else:
        print(0)

if __name__ == "__main__":
    main()
        