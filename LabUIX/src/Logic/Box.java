
package Logic;
import java.util.List;

public class Box {
    private int totalClientsAttending;
    private List<Client> waitingLine; 
    private int totalAttendingTime;
    private int actualTimeClient;
    private int AttendingClients;
    private int attendingTime;
    private int actualTime; 
    private Client actualClient; 
    private int boxNumber;
     
    public Box(int boxNumber){
        this.actualTimeClient= 0;
        this.AttendingClients= 0;
        this.totalAttendingTime= 0;
        this.actualClient= null;
        this.boxNumber= boxNumber;
    }
    public boolean free(){
        return actualClient== null;
    }

    public int getTotalClientsAttending() {
        return totalClientsAttending;
    }

    public List<Client> getWaitingLine() {
        return waitingLine;
    }
    
    public int getTotalAttendingTime() {
        return totalAttendingTime;
    }

    public int getActualTimeClient() {
        return actualTimeClient;
    }

    public int getAttendingClients() {
        return AttendingClients++;
    }
    
    public int getAttendingTime() {
        return attendingTime;
    }

    public int getActualTime() {
        return actualTime;
    }

    public Client getActualClient() {
        return actualClient;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

}
