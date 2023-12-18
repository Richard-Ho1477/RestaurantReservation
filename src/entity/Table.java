package entity;

public class Table {
    private String idCustomer;
    private String order;
    private String status;

    public Table (String idCustomer, String order, String status) {
        this.idCustomer = idCustomer;
        this.order = order;
        this.status = status;
    }

    public void setIdCsutomer (String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdCustomer() {
        return this.idCustomer;
    }

    public void setOrder (String order) {
        this.order = order;
    }

    public String getOrder() {
        return this.order;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
