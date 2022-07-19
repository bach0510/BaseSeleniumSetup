package ntscenum;

public enum Component {
    SERVICE_DASHBOARD_RECEPTIONIST("SERVICE_DASHBOARD_RECEPTIONIST"),
    CUSTOMER_INFO("Thông tin khách hàng");

    private String name ;

    private Component(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
