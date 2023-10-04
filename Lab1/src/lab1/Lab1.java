
package lab1;
import Logic.Box;
import Logic.Client;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean leave= false;
        if(!leave){
            System.out.println("--------------------------");
            System.out.println("|     ¡Bienvenidos!      |");
            System.out.println("|Seleccione una opcion:  |");
            System.out.println("| 1. Ingresar al banco   |");
            System.out.println("|       2. Salir         |");
            System.out.println("--------------------------");
            int option= sc.nextInt();
            
            switch (option){
                case 1:
                    System.out.print("Indique la cantidad de clientes a atender: ");
                    int amount= sc.nextInt();
                    simulateBank(amount);
                    break;
                case 2:
                    leave= true;
                    break;
            }
            System.out.println("Gracias por su visita");
            sc.close();
        }
    }
        public static void simulateBank(int amount) {
        List<Box> boxes = new ArrayList<>();
        Queue<Client> waitingQueue = new PriorityQueue<>(Comparator.comparing(Client::getPriority));
        for (int i = 1; i <= 4; i++) {
            boxes.add(new Box(i));
        }
        for (int i = 1; i <= amount; i++) {
            Client client = new Client(i);
            waitingQueue.add(new Client(i));
        }
        List<Client> orderClients = new ArrayList<>(waitingQueue);
        orderClients.sort(Comparator.comparing(Client::getClientNumber));
        System.out.println("Clientes generados:");
        for (Client client : orderClients) {
            System.out.println("Cliente " + client.getClientNumber() + " - Prioridad " + client.getPriority());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pulse intro para iniciar ");
        scanner.nextLine();// Wait for the user to press Enter to start

        int elapsedTime= 0;
       Queue<String> queue = new LinkedList<>();
        int clientNumber = 1;
        int totalWaitingTime = 0;
        int totalServiceTime = 0;
        int totalCustomers = 0;
        int[] ATMCustomers = new int[3];
        int[] ATMServiceTime = new int[3];
        Random random = new Random();
        
        for (int i = 0; i < 10; i++) {
            int priority = random.nextInt(4);
            String ticket = clientNumber + "";
            switch (priority) {
                case 0:
                    ticket += "A";
                    break;
                case 1:
                    ticket += "B";
                    break;
                case 2:
                    ticket += "C";
                    break;
                default:
                    ticket += "D";
                    break;
            }
            queue.add(ticket);
            clientNumber++;
        }

        while (!queue.isEmpty()) {
            String customer = queue.poll();
            int ATM= random.nextInt(3);
            int serviceTime = random.nextInt(6) + 1;
            totalServiceTime += serviceTime;
            totalCustomers++;
            ATMCustomers[ATM]++;
            ATMServiceTime[ATM] += serviceTime;
            totalWaitingTime += (ATMServiceTime[ATM] - serviceTime);

            System.out.println("Atendiendo al cliente prioridad " + customer + " en el cajero " + (ATM + 1) + " por " + serviceTime + " minutos.");
        }

        System.out.println("Promedio de tiempo de espera: " + (totalWaitingTime / totalCustomers) + " minutos.");
        for (int i = 0; i < 3; i++) {
            System.out.println("Promedio de tiempo de servicio en el cajero " + (i + 1) + ": " + (ATMServiceTime[i] / ATMCustomers[i]) + " minutos.");
        }
    }
}
    

