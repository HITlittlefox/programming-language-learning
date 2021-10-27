package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

/**
 * @author fox Email:963614756@qq.com
 * @Description CustomerView为主模块，负责菜单的显示和处理用户操作。
 * @date 2021年8月28日16点15分
 */
public class CustomerList {
    /**
     * @Description 用来保存客户对象的数组
     */
    // private static Customer[] customers = new Customer[0];
    /**
     * 记录已保存客户对象的数量
     */
    private Customer[] customers;
    private int total = 0;

    /**
     * @Description 用来初始化customers数组的构造器
     * @param totalCustomer：指定数组的长度
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * @Description 将指定的客户添加到数组中
     * @param customer
     * @return true:添加成功 false:添加失败
     */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length)
            return false;

        customers[total++] = customer;
        return true;

    }

    /**
     * @Description 修改指定索引位置的客户信息
     * @param index
     * @param cust
     * @return true:修改成功 false:修改失败
     */
    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index >= total) {
            return false;
        } else {
            customers[index] = cust;
            return true;
        }
    }

    /**
     * @Description 删除指定索引位置上的客户
     * @param index
     * @return true:删除成功 false:删除失败
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }
        // 最后一个有数据的元素需要清空为null
        customers[total--] = null;
        return true;
    }

    /**
     * @Description 获取所有的客户信息
     * @return
     */
    public Customer[] getAllCustomers() {
        // return customers;
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * @Description 获取指定索引位置上的客户
     * @param index
     * @return 如果找到了元素，则返回；如果没有找到，则返回null
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }

    /**
     * @Description 获取存储的客户的数量
     * @return
     */
    public int getTotal() {
        return total;
    }

}
