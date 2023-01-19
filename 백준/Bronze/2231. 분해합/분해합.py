import sys

def sumOfNum(num):
    tmp = [int(x) for x in str(num)]
    sum = 0
    for i in tmp: 
        sum += i
    return sum

def main():
    num = int(sys.stdin.readline())
    answer = 0
    cnt = 1
    while cnt < num:
        if cnt + sumOfNum(cnt) == num:
            answer = cnt
            break
        else : cnt += 1
    if cnt == num: answer = 0
    print(answer)

main()
