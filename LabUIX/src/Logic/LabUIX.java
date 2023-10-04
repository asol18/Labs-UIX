
package Logic;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LabUIX {

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
        
            while (!waitingQueue.isEmpty() || boxes.stream().anyMatch(box -> !box.isFree())) {
            System.out.println("Elapsed Time: " + elapsedTime + " minutes");

            for (Box box : boxes) {
                if (box.isFree() && !waitingQueue.isEmpty()) {
                    Client client = waitingQueue.poll();
                    box.AttendingClient(client);
                    box.incrementAttendingClients();
                } else {
                    box.incrementAttendingClients();
                }
                System.out.println(box.toString());
            }
            elapsedTime++;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Error en el temporizador");
        }
    }
        for (Box box : boxes) {
        System.out.println("------------------------------------");
        System.out.println(" Caja " + box.getBoxNumber() + ":");
        System.out.println("Clientes atendidos: " + box.getAttendingClients());
        System.out.println("Tiempo total de atención: " + box.getTotalAttendingTime() + " minutes");
    }
    System.out.println("------------------------------------");
    System.out.println("Total de clientes que ingresaron al banco: " + amount);
    System.out.println("Todos los clientes fueron atendidos en: " + "/n" + elapsedTime + " minutes.");
}
    }
 




 
    
