/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fcfs;

import java.util.*;

/**
 *
 * @author Yash Bahekar
 */
public class FCFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner in = new Scanner(System.in);
        System.out.println("Enter No of processes: ");
        int n = in.nextInt();

        String process[] = new String[n];
        int AT[] = new int[n];
        int BT[] = new int[n];
        int FT[] = new int[n];
        int TAT[] = new int[n];
        int WT[] = new int[n];
        int avgTAT = 0, avgWT = 0;

        int temp;
        String stemp;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter name of process " + (i + 1) + " : ");
            process[i] = in.next();

        }

        for (int i = 0; i < n; i++) {

            System.out.println("Enter Arrival time of process " + (i + 1) + " : ");
            AT[i] = in.nextInt();
            System.out.println("Enter Burst time of process " + (i + 1) + " : ");
            BT[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - (i + 1); j++) {
                if (AT[j] > AT[j + 1]) {

                    temp = AT[j];
                    AT[j] = AT[j + 1];
                    AT[j + 1] = temp;

                    temp = BT[j];
                    BT[j] = BT[j + 1];
                    BT[j + 1] = temp;

                    stemp = process[j];
                    process[j] = process[j + 1];
                    process[j + 1] = stemp;
                }

            }

        }
        
       for(int i =0;i<n;i++){
           
           if( i ==0){
               FT[i] = AT[i]+BT[i];
           }
           else{
               if(AT[i] > FT[i-1]){
                   FT[i] = AT[i]+BT[i];
               }
               else {
                   FT[i] = FT[i-1] + BT[i];
               }
           }
           
           TAT[i] = FT[i] - AT[i];
           WT[i] = TAT[i] -BT[i];
           avgTAT += TAT[i];
           avgWT += WT[i];
       }
       
       System.out.println("\t process \t Arrival Time \t Burst Time \t Finish Time \t Turn Arnd Time \t Waiting Time");
       for(int i =0;i<n;i++){
           System.out.println(" \t"+process[i]+" \t\t\t"+AT[i]+" \t\t"+BT[i]+" \t\t"+FT[i]+" \t\t"+TAT[i]+" \t\t"+WT[i]);
       }
       
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter No of Process: ");
//        int n = in.nextInt();
//
//        String Process[] = new String[n];
//
////        Input will be 
//        int AT[] = new int[n];
//        int BT[] = new int[n];
////        Output will be
//        int FT[] = new int[n];
//        int TAT[] = new int[n];
//        int WT[] = new int[n];
//// ************  Formulas ************
//// First FT then TAT --then--> WT.........
////        FT = AT + BT;
////        TAT = FT - AT
////        WT = TAT - BT
//
//        int temp;
//        String temp1;
//        
//        int avgTAT = 0;
//        int avgWT = 0;
//        
//        
//
//        System.out.println("Enter Process Names: ");
//
//        for (int i = 0; i < n; i++) {
//            Process[i] = in.next();
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println("Enter Process " + Process[i] + " Arrival Time: ");
//            AT[i] = in.nextInt();
//            System.out.println("Enter Process " + Process[i] + " Burst Time: ");
//            BT[i] = in.nextInt();
//        }
//
//        
//        
//        
////       here we are sorting the processes according to the AT of the process, process with lowest arrival time will be first and followed by the next lowest AT process
////       
////       for achieving this first 
////           for n=4,i = 0,---> j < 4 - (0+1) --> 3,-->> j = 0,1,2
////            
////           
////
////
////
////
////
//for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n - (i + 1); j++) {
//
//                if (AT[j] > AT[j + 1]) {   /// this condition will check the next process AT 
////                    if that is less than first process then the processes will be swapped and also all the AT , BT , Process names should also be swapped
//
//                    temp = AT[j];
//                    AT[j] = AT[j + 1];
//                    AT[j + 1] = temp;
//
//                    temp = BT[j];
//                    BT[j] = BT[j + 1];
//                    BT[j + 1] = temp;
//
//                    temp1 = Process[j];
//                    Process[j] = Process[j + 1];
//                    Process[j + 1] = temp1;
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//
//            if (i == 0) {
//                FT[i] = AT[i] + BT[i];
//            } else {
//
//                if (AT[i] > FT[i - 1]) {
//                    FT[i] = AT[i] + BT[i];
//                } else {
//                    FT[i] = FT[i - 1] + BT[i];
//                }
//            }
//            
//            TAT[i] = FT[i] - AT[i];
//            WT[i]  = TAT[i] - BT[i];    
//            
//            avgTAT += TAT[i];
//            avgWT += WT[i];
//        }
//
//        
//        System.out.println("\nProcess     AT      BT      FT      TAT    WT");
//        for (int i = 0; i < n; i++) {
//
//            System.out.println("   "+Process[i] + "   \t    "+ AT[i] + " \t    " + BT[i]+ " \t    "+ FT[i]+" \t    "+TAT[i]+" \t   "+WT[i]);
//        }

    }

}
