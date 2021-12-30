
# // 给定数列 1, 1, 1, 3, 5, 9, 17, \dots1,1,1,3,5,9,17,…，
# // 从第 4 项开始，每项都是前 3 项的和。
# // 求 第 2019032420190324 项的最后 4 位数字。


# // f(n) = f(n-1)+f(n-2)+f(n-3)
# // f(1)=f(2)=f(3)=1

import sys

sys.setrecursionlimit(1000000000000)  # 例如这里设置为十万

def fib(n):
    if (n == 0 or n == 1 or n == 2):
        return n
    else:
        return fib(n - 1) + fib(n - 2)+fib(n-3)


print(fib(2019032420190324))
# # 斐波那契数列
# # 使用递归
# def fib(n):
#     if n == 1 or n == 2:
#         return 1
#     return fib(n - 1) + fib(n - 2)
# # 输出了第10个斐波那契数列
# print fib(10)
# 以上实例输出了第10个斐波那契数列，结果为：
