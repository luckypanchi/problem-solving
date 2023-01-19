import sys

def main():
    n = int(sys.stdin.readline())
    li = [[0]*(n+2)]
    for i in range(n):
        li.append([0]+list(map(int, list(sys.stdin.readline()[:-1])))+[0])
    li.append([0]*(n+2))

    def dfs(start, li, answer, cnt):
        num1 = start[0]
        num2 = start[1]
        
        if li[num1][num2] == 1:
            if cnt == 0: answer.append(1)
            else: answer[-1] += 1
            li[num1][num2] = 0
            dfs((num1, num2+1), li, answer, cnt+1)
            dfs((num1+1, num2), li, answer, cnt+1)
            dfs((num1, num2-1), li, answer, cnt+1)
            dfs((num1-1, num2), li, answer, cnt+1)
    
    answer = []
    
    for i in range(1, n+2):
        for j in range(1, n+2):
            dfs((i, j), li, answer, 0)

    answer.sort()
    print(len(answer))
    for i in answer:
        print(i, end="\n")

main()    
