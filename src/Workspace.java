import java.util.*;
import java.time.LocalTime;
public class Workspace extends Gmail{
    private List<Meeting> calendar;

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        calendar.add(meeting);
    }
    public int findMaxMeetings() {
        calendar.sort(Comparator.comparing(Meeting::getEndTime));

        int maxMeetings = 0;
        LocalTime previousEndTime = LocalTime.MIN;

        for (Meeting meeting : calendar) {
            if (meeting.getStartTime().isAfter(previousEndTime)) {
                // This meeting can be attended without overlapping
                maxMeetings++;
                previousEndTime = meeting.getEndTime();
            }
        }

        return maxMeetings;

//        int maxMeetings = 0;
//        for (Meeting meeting : calendar) {
//            int overlappingMeetings = 0;
//            for (Meeting otherMeeting : calendar) {
//                if (meeting != otherMeeting &&
//                        meeting.getStartTime().isBefore(otherMeeting.getEndTime()) &&
//                        meeting.getEndTime().isAfter(otherMeeting.getStartTime())) {
//                    overlappingMeetings++;
//                }
//
//            }
//            maxMeetings = Math.max(maxMeetings, overlappingMeetings + 1);
//        }
//        return maxMeetings;
    }
}
