import java.time.LocalTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Workspace workspace = new Workspace("workspace@example.com");
        workspace.receiveMail(new Date(), "sender1@example.com", "Hello, this is a mail.");
        workspace.receiveMail(new Date(),"sender1@example.com","hi islam how are you. this is new mail");

        Meeting meeting1 = new Meeting(LocalTime.of(9, 0), LocalTime.of(10, 0));
        Meeting meeting2 = new Meeting(LocalTime.of(10, 30), LocalTime.of(11, 30));
        // Meeting m3 = new Meeting(LocalTime.of(12,40),LocalTime.of(12,52));

        workspace.addMeeting(meeting1);
        workspace.addMeeting(meeting2);
        //workspace.addMeeting(m3);


        int maxMeetings = workspace.findMaxMeetings();
        System.out.println("Maximum meetings that can be attended: " + maxMeetings);
    }
}