package user;

public class Employee {
    private String id;
    private String name;
    private String cabang;

    public Employee (String id, String name, String cabang){
        this.id = id;
        this.name = name;
        this.cabang = cabang;
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

    public void setCabang (String cabang){
        this.cabang = cabang;
    }

    public String cabang(){
        return this.cabang;
    }
}
