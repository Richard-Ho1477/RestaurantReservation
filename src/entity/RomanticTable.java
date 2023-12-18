package entity;

public class RomanticTable extends Table {
    private Integer capacity = 2;
    public RomanticTable (String idCustomer, String order, String status) {
        super (idCustomer, order, status);
    }

    public Integer getCapacity() {
        return this.capacity;
    }
}
