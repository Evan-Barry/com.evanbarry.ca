import javax.swing.*;

public class RobotAnalysis {
    public static void main(String[] args) {

        //A variable to store how many robots the user wants
        int numOfRobots = Integer.parseInt(JOptionPane.showInputDialog("How many robots do you want in your team?"));

        //Array of Robot objects with a set size given by the user
        Robot[] robotTeam = new Robot[numOfRobots];
        //Array of Robot object to store the top 2 robots by power duration
        Robot[] top2 = new Robot[2];

        //Creating a Robot object and giving it a reference name of r
        Robot r;

        //The variables to store the user input that will be given to new Robot objects
        String name;
        int numOfMotors;
        double pwrDuration;

        //For loop to cycle through the robotTeam array and set up new Robot objects and give details to the objects
        for(int i = 0; i < robotTeam.length; i++)
        {
            //getting user input
            name = JOptionPane.showInputDialog("Robot Name");
            numOfMotors = Integer.parseInt(JOptionPane.showInputDialog("Number of Motors"));
            pwrDuration = Double.parseDouble(JOptionPane.showInputDialog("Power Duration"));

            r = new Robot(name, numOfMotors, pwrDuration);//Setting up a new Robot with the Three argument constructor with input from the user

            robotTeam[i] = r;//Store this Robot object in the robotTeam array at a certain location

            Robot.setNumOfRobots(Robot.getNumOfRobots() + 1);//Counting the number of Robot object by incrementing the class attribute numOfRobots via accessor and mutator methods
        }

        display(robotTeam);//Calling the display method and passing through the robotTeam array
        largestNumOfMotors(robotTeam);//Calling the largestNumOfMotors method and passing through the robotTeam array

        JOptionPane.showMessageDialog(null, "Number of Robots: " + Robot.getNumOfRobots());//Displaying the number of Robot objects created via the getNumOfRobots method

        top2 = top2RobotsByDuration(robotTeam);//Calling the top2RobotsByDuration method and passing through the robotTeam array. This will return the top 2 Robots by duration into the top2 array

        JOptionPane.showMessageDialog(null, "Top 2 robots by power duration: \n" + top2[0].toString() + "\n" + top2[1].toString());//Displaying the top 2 robots by power duration
    }

    public static void display(Robot[] robotTeam)
    {
        JTextArea jta = new JTextArea("Team:\n");//Setting up a new JTextArea object called jta

        for(Robot r : robotTeam)//Enchanced For Loop, For each Robot object r in the robotTeam array
        {
            jta.append(r.toString() + "\n");//Add on the Robot object details to the JTextArea jta
        }

        JOptionPane.showMessageDialog(null, jta);//Display jta
    }

    public static void largestNumOfMotors(Robot[] robotTeam)
    {
        JTextArea jta = new JTextArea("Robot with largest number of motors:\n");//Setting up a new JTextArea object called jta

        int numOfMotors = 0, index = 0;//Variables to keep tracking the most number of motors and the Robot object that has the most number of motors

        for(int i = 0; i < robotTeam.length; i++)//For Loop, this will cycle thorugh the robotTeam array
        {
            if(robotTeam[i].getNumMotors() > numOfMotors)//If the current Robot object has more motors than the current number of most motors
            {
                index = i;//Set the index to current value of i to indicate this Robot object has most motors
                numOfMotors = robotTeam[i].getNumMotors();//Update the most number of motors
            }
        }

        jta.append(robotTeam[index].toString());//Add that Robot object to the JTextArea

        JOptionPane.showMessageDialog(null, jta);//Display the JTextArea
    }

    private static Robot[] top2RobotsByDuration(Robot[] robotTeam)
    {
        Robot[] top2 = new Robot[2];//Setting up a new Robot array called top2 and sitting its size to 2. This will store the top 2 Robot objects with the most power duration

        double pwrDur1 = 0.1, pwrDur2 = 0.0;//Setting initial values for top 2 power duration to compare to the power duration of Robot objects

        for(int i = 0; i < robotTeam.length; i++)//For Loop
        {
            if(robotTeam[i].getPwrDuration() > pwrDur1 && robotTeam[i].getPwrDuration() > pwrDur2)//If current Robot object has more power duration that current top 2
            {
                top2[1] = top2[0];//set current most power duration to number 2
                top2[0] = robotTeam[i];//set current Robot object to most power duration

                pwrDur2 = pwrDur1;//set value for 2nd most power duration to the current most power duration
                pwrDur1 = robotTeam[i].getPwrDuration();//set the value for most power duration to the current Robot object's power duration
            }

            else if(robotTeam[i].getPwrDuration() < pwrDur1 && robotTeam[i].getPwrDuration() > pwrDur2)//If current Robot object has less power duration that current first and more than second
            {
                top2[1] = robotTeam[i];//set current most power duration to current Robot object's power duration
                pwrDur2 = robotTeam[i].getPwrDuration();//set the value for 2nd most power duration to the current Robot object's power duration
            }
        }

        return top2;//return the top2 array
    }
}
