/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package priority;

/**
 *
 * @author Yash Bahekar
 */
import java.util.Scanner;

public class Priority {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter No of processes: ");
        int n = in.nextInt();
        
        String process[] = new String[n];
        int AT[] = new int[n];
        int BT[] = new int[n];
        int FT[] = new int[n];
        int TAT[] = new int[n];
        int WT[] = new int[n];
        int PP[] = new int[n];
        
        int temp;
        String stemp;
        
        for(int i = 0;i<n;i++){
            System.out.println("Enter name of process: "+(i+1)+" : ");
           process[i] = in.next();
        }
        for(int i = 0 ;i<n;i++){
            System.out.println("Enter Arrival Time of process "+process[i]+" : ");
            AT[i] = in.nextInt();
            System.out.println("Enter Burst Time of process "+process[i]+" : ");
            BT[i] = in.nextInt();
        }
//        System.out.println("Enter No of Processes: ");
//        int n = in.nextInt();
//
//        String process[] = new String[n];
//        int PP[] = new int[n];
//
//        int AT[] = new int[n];
//        int BT[] = new int[n];
//        int FT[] = new int[n];
//        int TAT[] = new int[n];
//        int WT[] = new int[n];
//
//        int avgTAT = 0, avgWT = 0;
//        int temp;
//        String stemp;
//
//        for (int i = 0; i < n; i++) {
//            System.out.println("Enter process " + (i + 1) + " name : ");
//            process[i] = in.next();
//
//        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.println("Enter Arrival Time of  process " + process[i] + " : ");
//            AT[i] = in.nextInt();
//
//            System.out.println("Enter Burst Time of  process " + process[i] + " : ");
//            BT[i] = in.nextInt();
//
//            System.out.println("Enter  process priority of  " + process[i] + " : ");
//            PP[i] = in.nextInt();
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n - (i + 1); j++) {
//
//                if (AT[j] > AT[j + 1]) {
//
//                    temp = AT[j];
//                    AT[j] = AT[j + 1];
//                    AT[j + 1] = temp;
//
//                    temp = BT[j];
//                    BT[j] = BT[j + 1];
//                    AT[j + 1] = temp;
//
//                    temp = PP[j];
//                    PP[j] = PP[j + 1];
//                    PP[j + 1] = temp;
//
//                    stemp = process[j];
//                    process[j] = process[j + 1];
//                    process[j + 1] = stemp;
//
//                }
//
//                if (AT[j] == AT[j + 1]) {
//
//                    if (PP[j] > PP[j + 1]) {
//
//                        temp = AT[j];
//                        AT[j] = AT[j + 1];
//                        AT[j + 1] = temp;
//
//                        temp = BT[j];
//                        BT[j] = BT[j + 1];
//                        BT[j + 1] = temp;
//
//                        temp = PP[j];
//                        PP[j] = PP[j + 1];
//                        PP[j + 1] = temp;
//
//                        stemp = process[j];
//                        process[j] = process[j + 1];
//                        process[j + 1] = stemp;
//                    }
//
//                }
//            }
//        }
//        
//        FT[0] = AT[0] + BT[0];
//        TAT[0] = FT[0] - AT[0];
//        WT[0] = TAT[0] - BT[0];
//        
//        for(int i= 1; i<n;i++){
//         FT[i] = FT[i-1] + BT[i];
//         TAT[i] = FT[i] - AT[i];
//         WT[i] = TAT[i] - BT[i];
//        }
//        
//        for(int i=0;i<n;i++){
//         avgTAT += TAT[i];   
//         avgWT += WT[i];   
//        }
//        
        
            System.out.format("%20s%20s%20s%20s%20s%20s%20s\n", "ProcessId", "BurstTime", "ArrivalTime", "Priority", "FinishTime", "WaitingTime", "TurnAroundTime");
            for (int i = 0; i < n; i++) {
                System.out.format("%20s%20d%20d%20d%20d%20d%20d\n", process[i], BT[i], AT[i], PP[i], FT[i], WT[i], TAT[i]);
            }

            System.out.println("\naverage tat is " + (float) (avgTAT / n));
            System.out.println("average wt is " + (float) (avgWT / n));
            in.close();
        }

    }

