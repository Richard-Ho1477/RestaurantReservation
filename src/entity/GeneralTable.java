package entity;

public class GeneralTable extends Table {
    private Integer capacity = 4;
    public GeneralTable (String idCustomer, String order, String status) {
        super (idCustomer, order, status);
    }

    public Integer getCapacity() {
        return this.capacity;
    }
}
