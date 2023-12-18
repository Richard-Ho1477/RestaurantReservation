package menu;

public class Menu {
    private String id;
    private String name;
    private Integer price;

    public Menu (String id, String name, Integer price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId (String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrice (Integer price){
        this.price = price;
    }

    public Integer getPrice(){
        return this.price;
    }
}
