import sys
input = sys.stdin.readline


def isPalindrome(num):
    str_num = str(num)

    for i in range(len(str_num)//2+1):
        if str_num[i] != str_num[len(str_num)-1-i]:
            return False

    return True


def isPrime(num):
    if num == 1: return False

    for i in range(2, num//2+1):
        if num % i == 0:
            return False

    return True


def main():
    num = int(input())

    while True:
        if isPalindrome(num) and isPrime(num):
            print(num)
            return
        else:
            num += 1


main()
