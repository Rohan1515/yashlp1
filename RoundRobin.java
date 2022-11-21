/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package roundrobin;

import java.util.*;

/**
 *
 * @author Yash Bahekar
 */
public class RoundRobin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter No of Processes: ");
        int process = in.nextInt();
        
        int remain = process;
        int time,count,flag = 0;
        
        int AT[] = new int[process];
        int BT[] = new int[process];
        int RBT[] = new int[process];
        
        int avgTAT=0,avgWT=0;
        
        for(count = 0;count<process;count++){
            System.out.println("Enter Arrival time of process "+ (count +1)+" : ");
            AT[count] = in.nextInt();
            System.out.println("Enter Burst time of process "+ (count +1)+" : ");
            BT[count] = in.nextInt();
        
            RBT[count] = BT[count];
        }
        
        System.out.println("Enter Time Quantum: ");
        int Time_Quantum = in.nextInt();
        
        System.out.println("\tIndex\tArrival TIme\tBurst Time\tTurn Around Time\tWaiting Time");
        for(time = 0,count=0; remain!=0;){
            
            if((RBT[count] <= Time_Quantum) && RBT[count]>0){
                
                time += RBT[count];
                RBT[count] = 0;
                flag =1;
            }
            else if(RBT[count] > 0){
                RBT[count] -= Time_Quantum;
                time += Time_Quantum;
            }
            
            if(RBT[count] == 0 && flag==1){
                remain--;
                System.out.println("\t"+(count+1)+"\t\t"+AT[count]+"\t\t"+BT[count]+"\t\t"+(time-AT[count])+"\t\t"+(time-AT[count]-BT[count]));
                flag = 0;
                avgTAT = time-AT[count];
                avgWT = time-AT[count] - BT[count];
            }
            
            if(count >= process-1){
                count = 0;
                
            }
            else if(AT[count] < time){
                count++;
            }
            else{
                count=0;
            }
        }
        

//        System.out.println("Enter No of processes: ");
//        int process = in.nextInt();
//
//        int remain = process;
//        int flag = 0, time, count;
//        int AT[] = new int[process];
//        int BT[] = new int[process];
//        int RBT[] = new int[process];
//        int avgWT = 0, avgTAT = 0;
//
//        for (int i = 0; i < process; i++) {
//            System.out.println("Enter Arrival time of process " + (i + 1) + " : ");
//            AT[i] = in.nextInt();
//            System.out.println("Enter Burst time of process " + (i + 1) + " : ");
//            BT[i] = in.nextInt();
//
//            RBT[i] = BT[i];
//        }
//
//        System.out.println("Enter Time Quantum: ");
//        int Time_Quantum = in.nextInt();
//
//        for (time = 0, count = 0; remain != 0;) {
//
//            if (RBT[count] <= Time_Quantum && RBT[count] > 0) {
//
//                time += RBT[count];
//                RBT[count] = 0;
//                flag = 1;
//
//            } else if (RBT[count] > 0) {
//                RBT[count] -= Time_Quantum;
//                time += Time_Quantum;
//            }
//
//            if (RBT[count] == 0 && flag == 1) {
//                remain--;
//                System.out.println((count + 1) + "\t" + (time - AT[count]) + "\t" + (time - AT[count] - BT[count]));
//                avgTAT += time - AT[count];
//                avgWT += time - AT[count] - BT[count];
//                flag = 0;
//            }
//
//            if (count == process - 1) {
//                count = 0;
//            } else if (AT[count + 1] <= time) {
//                count++;
//            }
//            else{
//                count = 0;
//            }
//        }
        System.out.println("Average Waiting Time: "+avgWT/process);
        System.out.println("Average Turn Around Time: "+avgTAT/process);
    }

}
