
package Logic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Client {
    private int clientNumber;
    private int time;
    private String priority;
    private int tramiteTime;
    
    public Client(int clientNumber){
        this.clientNumber= clientNumber;
        this.time= 0;
        this.priority= priority;
        this.tramiteTime= tramiteTime;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getTramiteTime() {
        return tramiteTime;
    }

    public void setTramiteTime(int tramiteTime) {
        this.tramiteTime = tramiteTime;
    }
    public void elapsedTime(){
        time++;
    }
    private String generatedAleatoryPriority(int clientNumber){
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomPriority = random.nextInt(4);
            switch (randomPriority) {
                case 0:
                    priority = "A";
                    break;
                case 1:
                    priority = "B";
                    break;
                case 2:
                    priority += "C";
                    break;
                default:
                    priority += "D";
                    break;
            }
        }
        return priority + Integer.toString(clientNumber);
    }
    private int AleatoryTime() {
        return (int) (Math.random() * 23) + 2;
    }
}
