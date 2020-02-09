import java.util.Scanner;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Clock{
    private int timeHours;
    private int timeMinutes;
    private int alarmHours;
    private int alarmMinutes;
    private String ampm;

    public Clock(){
        timeHours = 00;
        timeMinutes = 00;
    }
    //setters for time & alarms
    public void setTimeHours(int t_hour1) {
        this.timeHours = t_hour1;
    }

    public void setTimeMinutes(int t_min1) {
        this.timeMinutes = t_min1;
    }

    public void setAlarmHours(int alarmHours) {
        this.alarmHours = alarmHours;
    }

    public void setAlarmMinutes(int alarmMinutes) {
        this.alarmMinutes = alarmMinutes;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    //getters for time and alarms
    public int getTimeHours() {
        return timeHours;
    }

    public int getTimeMinutes() {
        return timeMinutes;
    }

    public int getAlarmHours() {
        return alarmHours;
    }

    public int getAlarmMinutes() {
        return alarmMinutes;
    }

    public String getAmpm() {
        return ampm;
    }


//function to set time

    public void setTime() {
        //set hours
        System.out.println("Enter Hour");
        Scanner t_hour = new Scanner(System.in);
        int t_hour1 = t_hour.nextInt();
        //check if input is right
        if (t_hour1 > 24) {
            System.out.println("Hour is invalid");
            Scanner t_hour_retry = new Scanner(System.in);
            t_hour1 = t_hour_retry.nextInt();
        }
        //set minutes
        System.out.println("Enter Minutes");
        Scanner t_min = new Scanner(System.in);
        int t_min1 = t_min.nextInt();
        //check if minutes are more than 60, subtract and add extra hours if so
        if (t_min1 >= 60){
            t_hour1 = t_hour1 + 1;
            if (t_hour1 >12) {
                t_hour1 = t_hour1 - 12;
            }
            t_min1 = t_min1 - 60;
        }
        timeHours = t_hour1;
        timeMinutes = t_min1;
        setTimeHours(t_hour1);
        setTimeMinutes(t_min1);

        System.out.println("Time has been set to " + getTimeHours() +":" + getTimeMinutes());
    }
    //convert time to 12-hour format
    public void converter_12(int timeHours, int timeMinutes){
        if (timeHours < 12){
            ampm = "AM";
        }
        if (timeHours >12){
            timeHours = timeHours - 12;
            ampm = "PM";
        }

        setTimeHours(timeHours);
        setTimeMinutes(timeMinutes);
    }
    //tostring method for date conversion [not used yet]
    @Override
    public String toString() {
        return timeHours + ":" + timeMinutes;
    }

    //display in 12-hour format
    public void display_12(){
        int h12 = getTimeHours();
        int m12 = getTimeMinutes();
        converter_12(h12, h12);
        /**DateFormat displayFormat = new SimpleDateFormat("HH:mm a");
        String sdate = toString();
        Date d = dateFormat.parse(sdate);
**/


        System.out.println("Current time is " + getTimeHours() + ":" + getTimeMinutes());
        System.out.println();
    }

    //display in 24-hour format
    public void display_24(){
        System.out.println("Current time is " + getTimeHours() +":"+ getTimeMinutes());
        System.out.println();
    }

    //set alarm
    public void setAlarm(){
        System.out.println("Enter Hour");
        Scanner a_hour = new Scanner(System.in);
        int a_hour1 = a_hour.nextInt();
        if (a_hour1 > 24) {
            System.out.println("Hour is invalid");
        }


        System.out.println("Enter Minutes");
        Scanner a_min = new Scanner(System.in);
        int a_min1 = a_min.nextInt();
        if (a_min1 >= 60){
            a_hour1 = a_hour1 + 1;
            if (a_hour1 >12) {
                a_hour1 = a_hour1 - 12;
            }
            a_min1 =a_min1 - 60;
        }
        alarmHours = a_hour1;
        alarmMinutes = a_min1;
        setAlarmHours(a_hour1);
        setTimeMinutes(a_min1);

        System.out.println("Alarm has been set for " + getAlarmHours() +":" + getAlarmMinutes());

    }

    //menu for user interaction
    public void menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("-------------------------\n" +
                "Alarm Clock App. " + "\n -------------------------\n" +
                "The time now is "+ getTimeHours() + ":"
                +getTimeMinutes() + "\n -------------------------\n"
                + "What would you like to do?");
        System.out.println("-------------------------\n");
        System.out.println("1 - Display time in 12 hour format");
        System.out.println("2 - Display time in 24 hour format");
        System.out.println("3 - Set the time");
        System.out.println("4 - Set Alarm");
        System.out.println("5 - Quit");

        selection = input.nextInt();
        switch (selection){
            case 1: display_12();
            menu();
            break;

            case 2: display_24();
            menu();
            break;

            case 3: setTime();
            menu();
            break;
            case 4: setAlarm();
            menu();
            break;
            case 5: break;


        }
    }
//main method to run the program
public static void main (String[] args){
        Clock test = new Clock();
        test.menu();
}

}
