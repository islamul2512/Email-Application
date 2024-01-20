import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gmail extends Email{
    private int inboxCapacity;
    private List<Mail> inbox;
    private List<Mail> trash;
    //private Date date;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();
    }
    public void receiveMail(Date date, String senderId, String message) {
        if (inbox.size() >= inboxCapacity) {
            moveOldestToTrash();
        }
        inbox.add(new Mail(date, senderId, message));
    }

    public void deleteMail(String message) {
        for (Mail mail : inbox) {
            if (mail.getMessage().equals(message)) {
                trash.add(mail);
                inbox.remove(mail);
                break;
            }
        }
    }
    public String findLatestMessage() {
        if (inbox.isEmpty()) {
            return null;
        }
        return inbox.get(inbox.size() - 1).getMessage();
    }

    public String findOldestMessage() {
        if (inbox.isEmpty()) {
            return null;
        }
        return inbox.get(0).getMessage();
    }
    public int findMailsBetweenDates(Date start, Date end) {
        int count = 0;
        for (Mail mail : inbox) {
            if (mail.getDate().compareTo(start) >= 0 && mail.getDate().compareTo(end) <= 0) {
                count++;
            }
        }
        return count;
    }
    public int getInboxSize() {
        return inbox.size();
    }

    public int getTrashSize() {
        return trash.size();
    }

    public void emptyTrash() {
        trash.clear();
    }

    public int getInboxCapacity() {
        return inboxCapacity;
    }

    private void moveOldestToTrash() {
        trash.add(inbox.remove(0));
    }
    private static class Mail {
        private Date date;

        private String senderId;
        private String message;

        public Mail(Date date, String senderId, String message) {
            this.date = date;
            this.senderId = senderId;
            this.message = message;
        }

        public Date getDate() {
            return date;
        }

        public String getMessage() {
            return message;
        }
    }
}
