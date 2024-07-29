/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 91807
 */
// Product Class
class Robot {
    private String head;
    private String body;
    private String arms;
    private String legs;

    public void setHead(String head) {
        this.head = head;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "Robot [head=" + head + ", body=" + body + ", arms=" + arms + ", legs=" + legs + "]";
    }
}

// Abstract Builder Interface
interface RobotBuilder {
    void buildHead();
    void buildBody();
    void buildArms();
    void buildLegs();
    Robot getRobot();
}

// Concrete Builder for Humanoid Robot
class HumanoidRobotBuilder implements RobotBuilder {
    private Robot robot;

    public HumanoidRobotBuilder() {
        this.robot = new Robot();
    }

    @Override
    public void buildHead() {
        robot.setHead("Humanoid Head");
    }

    @Override
    public void buildBody() {
        robot.setBody("Humanoid Body");
    }

    @Override
    public void buildArms() {
        robot.setArms("Humanoid Arms");
    }

    @Override
    public void buildLegs() {
        robot.setLegs("Humanoid Legs");
    }

    @Override
    public Robot getRobot() {
        return this.robot;
    }
}

// Concrete Builder for Industrial Robot
class IndustrialRobotBuilder implements RobotBuilder {
    private Robot robot;

    public IndustrialRobotBuilder() {
        this.robot = new Robot();
    }

    @Override
    public void buildHead() {
        robot.setHead("Industrial Head");
    }

    @Override
    public void buildBody() {
        robot.setBody("Industrial Body");
    }

    @Override
    public void buildArms() {
        robot.setArms("Industrial Arms");
    }

    @Override
    public void buildLegs() {
        robot.setLegs("Industrial Legs");
    }

    @Override
    public Robot getRobot() {
        return this.robot;
    }
}

// Director Class
class RobotDirector {
    private RobotBuilder robotBuilder;

    public RobotDirector(RobotBuilder robotBuilder) {
        this.robotBuilder = robotBuilder;
    }

    public Robot constructRobot() {
        robotBuilder.buildHead();
        robotBuilder.buildBody();
        robotBuilder.buildArms();
        robotBuilder.buildLegs();
        return robotBuilder.getRobot();
    }
}

// Client Code
public class BuilderPattern {
    public static void main(String[] args) {
        RobotBuilder humanoidBuilder = new HumanoidRobotBuilder();
        RobotDirector director = new RobotDirector(humanoidBuilder);
        Robot humanoidRobot = director.constructRobot();
        System.out.println(humanoidRobot);

        RobotBuilder industrialBuilder = new IndustrialRobotBuilder();
        director = new RobotDirector(industrialBuilder);
        Robot industrialRobot = director.constructRobot();
        System.out.println(industrialRobot);
    }
}

