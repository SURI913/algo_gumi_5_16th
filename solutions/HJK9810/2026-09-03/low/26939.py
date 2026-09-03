def algorithm():
    N = int(input())
    tree = [0] * (N + 1)
    value = 1

    def inorder(node):
        nonlocal value

        if node > N: return
        inorder(node * 2)
        tree[node] = value
        value += 1
        inorder(node * 2 + 1)

    inorder(1)
    return f"{tree[1]} {tree[N // 2]}"

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
