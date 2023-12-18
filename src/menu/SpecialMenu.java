package menu;

public class SpecialMenu extends Menu{
    private String story;
    public SpecialMenu (String id, String name, Integer price, String story){
        super(id, name, price);
        this.story = story;
    }

    public void setStory (String story){
        this.story = story;
    }

    public String getStory(){
        return this.story;
    }
}