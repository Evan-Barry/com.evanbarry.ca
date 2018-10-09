public class Robot {

    //Declaring the attributes
    private String name;
    private int numMotors;
    private double pwrDuration;
    private static int numOfRobots;

    //accessor methods
    public String getName()
    {
        return name;
    }

    public int getNumMotors()
    {
        return numMotors;
    }

    public double getPwrDuration()
    {
        return pwrDuration;
    }

    public static int getNumOfRobots()//Modification to display the total number of robots created from this class in the RobotAnalysis class
    {
        return numOfRobots;
    }

    //Mutator methods
    public void setName(String name)
    {
        this.name = name;
    }

    public void setNumMotors(int numMotors)
    {
        this.numMotors = numMotors;
    }

    public void setPwrDuration(double pwrDuration)
    {
        this.pwrDuration = pwrDuration;
    }

    public static void setNumOfRobots(int numOfRobots)//Modification to display the total number of robots created from this class in the RobotAnalysis class
    {
        Robot.numOfRobots = numOfRobots;
    }

    //toString method to output the details of a robot object
    public String toString()
    {
        return "Name: " + getName() +
                "\nNumber of Motors: " + getNumMotors() +
                "\nPower Duration: " + getPwrDuration();
    }

    //no argument constructor with default attributes set
    public Robot()
    {
        setName("No Name Set");
        setNumMotors(0);
        setPwrDuration(0.0);
    }

    //Three argument constructor to give an object data from driver class
    public Robot(String name, int numMotors, double pwrDuration)
    {
        setName(name);
        setNumMotors(numMotors);
        setPwrDuration(pwrDuration);
    }


}
