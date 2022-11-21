/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sjf;

import java.util.*;

/**
 *
 * @author Yash Bahekar
 */
public class SJF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner in = new Scanner(System.in);

        System.out.println("Enter No of processes; ");
        int n = in.nextInt();

        String process[] = new String[n];
        int AT[] = new int[n];
        int BT[] = new int[n];
        int FT[] = new int[n];
        int TAT[] = new int[n];
        int WT[] = new int[n];
        int RBT[] = new int[n];
        int avgTAT = 0, avgWT = 0;

        int Complt = 0, CT = 0;
        int FLAG[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Name of process " + (i + 1) + " : ");
            process[i] = in.next();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Arrival Time of process " + process[i] + " : ");
            AT[i] = in.nextInt();
            System.out.println("Enter Burst Time of process " + process[i] + " : ");
            BT[i] = in.nextInt();

            FLAG[i] = 0;
            RBT[i] = BT[i];
        }

        while (true) {
            int min = 99, c = n;

            if (Complt == n) {
                break;
            }

            for (int i = 0; i < n; i++) {

                if (AT[i] <= CT && FLAG[i] == 0 && BT[i] < min) {
                    min = BT[i];
                    c = i;
                }
            }
            if (c == n) {
                CT++;
            } else {
                BT[c]--;
                CT++;

                if (BT[c] == 0) {
                    FT[c] = CT;
                    FLAG[c] = 1;
                    Complt++;
                }

            }
        }

        for (int i = 0; i < n; i++) {
            TAT[i] = FT[i] - AT[i];
            WT[i] = TAT[i] - RBT[i];
            avgTAT += TAT[i];
            avgWT += WT[i];
        }

//        System.out.println("Enter No of Processes: ");
//        int n = in.nextInt();
//        
//        String process[] = new String[n];
//        int AT[] = new int[n];
//        int BT[] = new int[n];
//        int FT[] = new int[n];
//        int TAT[] = new int[n];
//        int WT[] = new int[n];
//        
//        int FLAG[] = new int[n];   // flag for indicating completed process...
//        int RBT[] = new int [n];   // RBT -  Remaining Burst Time 
//        float avgTAT= 0,avgWT=0;
//        
//        int CT = 0,Complt = 0;
//        
//        for(int i = 0 ; i<n;i++){
//            System.out.println("Enter name of process "+ (i+1) +" : ");
//            process[i] = in.next();
//        }
//        
//        for(int i = 0 ; i<n;i++){
//            System.out.println("Enter Arrival Time of process "+ process[i] +" : ");
//            AT[i] = in.nextInt();
//            
//            System.out.println("Enter Burst Time of process "+ process[i] +" : ");
//            BT[i] = in.nextInt();
//            
//            FLAG[i] = 0;
//            RBT[i] = BT[i];
//        }
//        
//        
//        while(true){
//            
//            int min = 99, c=n;
//            
//            if(Complt == n){
//                break;
//            }
//            
//            for(int i = 0; i<n;i++){
//                
//                if(AT[i] <= CT && (FLAG[i] == 0) && BT[i] < min){
//                    min = BT[i];
//                    c = i;
//                }
//            } 
//                if(c==n){
//                    CT++;
//                }
//                else{
//                    BT[c]--;
//                    CT++;
//                    
//                    if(BT[c] == 0){
//                        FT[c] = CT;
//                        FLAG[c] = 1;
//                        Complt++;
//                    }
//                    
//                }
//            
//        }
//            for(int i = 0 ; i<n;i++){
//                
//         
//                TAT[i] = FT[i] - AT[i];
//                WT[i] = TAT[i]- RBT[i];
//                avgWT += WT[i];
//                avgTAT += TAT[i];
//            }
//        
//        
        System.out.println("Process   AT   BT   FT   TAT   WT");
        for (int i = 0; i < n; i++) {
            System.out.println("    " + process[i] + "     " + AT[i] + "    " + RBT[i] + "     " + FT[i] + "    " + TAT[i] + "     " + WT[i]);
        }

        System.out.println("\naverage tat is " + (float) (avgTAT / n));
        System.out.println("average wt is " + (float) (avgWT / n));
        in.close();

    }

}
