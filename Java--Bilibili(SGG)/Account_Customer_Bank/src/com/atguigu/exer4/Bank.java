package com.atguigu.exer4;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;

    public Bank() {
        customers = new Customer[10];
    }
    /*
     * @Author fox
     * @Description //添加客户
     * @Date 16:56 2021/9/2
     * @Param
     * @return
     */

    public void addCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customers[numberOfCustomers] = customer;
        numberOfCustomers++;

    }
    /*
     * @Author fox
     * @Description //获取客户的个数
     * @Date 16:56 2021/9/2
     * @Param
     * @return
     */

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    /*
     * @Author fox
     * @Description //获取指定位置上的客户
     * @Date 16:57 2021/9/2
     * @Param
     * @return
     */

    public Customer getCustomer(int index) {
//        return customers[index];
        if (index >= 0 && index < numberOfCustomers) {
            return customers[index];

        }
        return null;
    }

}
