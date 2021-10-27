package HomeWork;

class Telephone {
    private String phoneBrand;
    private String phoneNumber;
    private int phoneTime;
    private double phoneRate;

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneTime() {
        return phoneTime;
    }

    public void setPhoneTime(int phoneTime) {
        this.phoneTime = phoneTime;
    }

    public double getPhoneRate() {
        return phoneRate;
    }

    public void setPhoneRate(double phoneRate) {
        this.phoneRate = phoneRate;
    }

    //计算话费
    public double calculate() {
        return ((int) (getPhoneTime() / 60)) * getPhoneRate();
    }

    //显示信息
    @Override
    public String toString() {
        return "品牌:" + getPhoneBrand() + " 号码:" + getPhoneNumber() + " 总通话时长:" + getPhoneTime() + "seconds" + " 费率:" + getPhoneRate() + "yuan/min";
    }
}

class Mobilephone extends Telephone//建立Mobilephone子类
{
    private String netType;//网络类型
    private int callInTime;//被叫时间
    //被叫不花钱，使用(总通话时间-被叫时间)*费率

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    //显示被叫时间
    public int getCallInTime() {
        return callInTime;
    }

    //得到被叫时长
    public void setCallInTime(int callInTime) {
        this.callInTime = callInTime;
    }

    //显示信息
    @Override
    public String toString() {
        return "品牌:" + getPhoneBrand() + " 号码:" + getPhoneNumber() + " 总通话时长:" + getPhoneTime() + "seconds" + " 费率:" + getPhoneRate() + "yuan/min" + " 网络类型:" + getNetType() + " 被叫时间:" + getCallInTime() + "seconds";
    }

    //计算话费
    public double calculate() {
        System.out.print("MobilePhone的计费方法:\n");
        return (int) ((getPhoneTime() - getCallInTime()) / 60) * getPhoneRate();
    }
}


public class TelephoneTest {
    public static void main(String[] args) {

        //父类对象测试
        Telephone phone = new Telephone();
        phone.setPhoneBrand("phone1");
        phone.setPhoneNumber("1786311****");
        phone.setPhoneTime(120);
        phone.setPhoneRate(1);

        System.out.println("父类对象测试");
        System.out.println("话费：" + phone.calculate() + "yuan");
        System.out.println("显示：" + phone.toString());

        System.out.println("==================================");

        //子类对象测试
        Mobilephone xiaomi11 = new Mobilephone();
        xiaomi11.setPhoneBrand("xiaomi");
        xiaomi11.setPhoneNumber("xiaomi");
        xiaomi11.setPhoneRate(2.0);
        xiaomi11.setPhoneTime(180);
        xiaomi11.setCallInTime(60);
        xiaomi11.setNetType("5G");

        System.out.println("子类对象测试");
        System.out.println("话费：" + xiaomi11.calculate() + "yuan");
        System.out.println("显示：" + xiaomi11.toString());


    }
}
