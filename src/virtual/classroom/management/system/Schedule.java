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

    public Schedule(String date, String time, String topics) {
        this.date = date;
        this.time = time;
        this.topics = topics;
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

    @Override
    public String toString() {
        return "Schedule{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", topics='" + topics + '\'' +
                '}';
    }
}
