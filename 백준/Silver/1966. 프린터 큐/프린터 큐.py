import sys

input = sys.stdin.readline


def main():
    k = int(input())

    for _ in range(k):

        n, m = map(int, input().split())
        nums = list(map(int, input().split()))
        index = [0] * n
        index[m] = 1
        answer = 0

        while nums:

            if nums[0] == max(nums):
                answer += 1

                if index[0] == 1:
                    print(answer)
                    break

                else:
                    del nums[0]
                    del index[0]

            else:

                nums.append(nums[0])
                index.append(index[0])

                del nums[0]
                del index[0]


main()
