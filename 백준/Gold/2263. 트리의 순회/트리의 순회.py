import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline


def solve(position, postorder, in_start, in_end, post_start, post_end):

    if in_start > in_end or post_start > post_end:
        return

    root = postorder[post_end]
    idx = position[root]

    sys.stdout.write("%d " % root)

    left = idx - in_start
    solve(
        position,
        postorder,
        in_start,
        in_start + left - 1,
        post_start,
        post_start + left - 1,
    )
    solve(position, postorder, idx + 1, in_end, post_start + left, post_end - 1)


n = int(input())
inorder = list(map(int, input().split()))
postorder = list(map(int, input().split()))
position = [0] * (n + 1)
for i in range(n):
    position[inorder[i]] = i

solve(position, postorder, 0, n - 1, 0, n - 1)
