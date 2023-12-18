package menu;

public class LocalMenu extends Menu{
    private String location;
    private String characteristic;
    public LocalMenu (String id, String name, Integer price, String location, String characteristic){
        super(id, name, price);
        this.location = location;
        this.characteristic = characteristic;
    }

    public void setLocation (String location){
        this.location = location;
    }

    public String getLocation (){
        return this.location;
    }

    public void setCharacteristic (String characteristic){
        this.characteristic = characteristic;
    }

    public String getCharacteristic (){
        return this.characteristic;
    }
}
