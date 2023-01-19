import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)

def main():
    n = int(input())
    dice = [list(map(int, input().split())) for _ in range(n)]

    def oppo(num):
        if num == 0 or num == 5: return 5-num
        elif num == 1 or num == 2: return num+2
        else: return num-2

    answer = 0
    result = []

    def getSum(num, cnt):
        nonlocal answer

        if cnt == n: 
            answer = max(answer, sum(result))
            if answer == 6*n: 
                print(answer) 
                sys.exit()
            result.clear()
            return

        nxt = oppo(dice[cnt].index(num))        # nxt는 index 값
        tmp = [1, 2, 3, 4, 5, 6]
        tmp.remove(num)
        tmp.remove(dice[cnt][nxt])
        result.append(max(tmp))
        getSum(dice[cnt][nxt], cnt+1)

    for i in range(6):      # i는 index 값
        getSum(dice[0][i], 0)

    print(answer)

if __name__ == "__main__":
    main()