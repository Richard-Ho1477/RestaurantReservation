package entity;

public class FamilyTable extends Table {
    private Integer capacity = 10;
    public FamilyTable (String idCustomer, String order, String status) {
        super (idCustomer, order, status);
    }

    public Integer getCapacity() {
        return this.capacity;
    }
}
