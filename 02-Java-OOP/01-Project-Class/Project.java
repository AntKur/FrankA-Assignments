public class Project{
    private String name, description;

    public Project(){
        this("Project", "This is a description.");
    }

    public Project(String name){
        this.name = name;
    }

    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String elevatorPitch(){
        String s = name + ": " +description;
        return s;
    }
}