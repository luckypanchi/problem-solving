import sys

def main():
    num = int(sys.stdin.readline())
    cnt = 666
    counter = 0
    while True:
        if counter == num: break
        temp = [str(x) for x in str(cnt)]
        for i in range(len(temp)-2):
            if temp[i] == '6' and temp[i+1] == '6' and temp[i+2] == '6':
                counter += 1
                break
        cnt += 1
        

    print(cnt-1)

if __name__ == "__main__":
    main()