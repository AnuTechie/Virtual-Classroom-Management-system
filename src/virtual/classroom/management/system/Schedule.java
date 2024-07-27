/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package virtual.classroom.management.system;

/**
 *
 * @author 91807
 */
public class Schedule {
    private String date;
    private String time;
    private String topics;
    private int id;

    public Schedule(String date, String time, String topics,int id) {
        this.date = date;
        this.time = time;
        this.topics = topics;
        this.id=id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getTopics() {
        return topics;
    }
    
    public int getId()
    {
        return id;
    }
    @Override
    public String toString() {
        return "Schedule{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", topics='" + topics + '\'' +
                '}';
    }
}
