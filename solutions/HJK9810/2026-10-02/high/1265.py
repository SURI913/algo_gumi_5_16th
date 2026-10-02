def algorithm():
    dalent, group = map(int, input().split())

    default_val = dalent // group
    more_count = dalent % group

    return ((default_val + 1) ** more_count) * (default_val ** (group - more_count))

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
