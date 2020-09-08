public class ProjectTest{

    public static void main(String[] args){
        Project projectOne = new Project();
        System.out.println(projectOne.getDescription());
        projectOne.setDescription("This is the new description.");
        System.out.println(projectOne.elevatorPitch());

        Project projectTwo = new Project("Second Project");
        System.out.println(projectTwo.getName());
        projectTwo.setName("2nd Project Name");
        System.out.println(projectTwo.elevatorPitch());

        Project projectThree = new Project("Super Fun", "A program all about fun!");
        System.out.println(projectThree.elevatorPitch());
    }
}