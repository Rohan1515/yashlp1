/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banker;

import java.util.*;

/**
 *
 * @author Yash Bahekar
 */
public class Banker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);

        System.out.println("Enter No of processes: ");
        int processes = in.nextInt();
//        System.out.println("Enter No of resources: ");
        int resources = in.nextInt();

        int allocation[][] = new int[processes][resources];
        int MAX[][] = new int[processes][resources];
        int available[] = new int[resources];

        int counter = 0;

        for (int i = 0; i < processes; i++) {
            System.out.println("Enter Allocated resources for process " + (i + 1) + " : ");
            for (int j = 0; j < resources; j++) {
                allocation[i][j] = in.nextInt();
            }
            System.out.println();
        }

        for (int i = 0; i < processes; i++) {
            System.out.println("Enter Maximum needed resources for process " + (i + 1) + " : ");
            for (int j = 0; j < resources; j++) {
                MAX[i][j] = in.nextInt();
            }
            System.out.println();
        }

        System.out.println("Enter Available resources : ");
        for (int i = 0; i < resources; i++) {

            available[i] = in.nextInt();
        }
//        
//        int allocation[][] = {{0, 0, 1},
//        {3, 0, 0},
//        {1, 0, 1},
//        {2, 3, 2},
//        {0, 0, 3}};
//
//        int MAX[][] = {{7, 6, 3},
//        {3, 2, 2},
//        {8, 0, 2},
//        {2, 1, 2},
//        {5, 2, 3}};

//        int available[] = {2, 3, 2}; //available resources
        int F[] = new int[processes];
        int ans[] = new int[processes];
        int ind = 0;
        int safe = 0;

        for (int i = 0; i < processes; i++) {
            F[i] = 0;
            counter++;
        }

        int need[][] = new int[processes][resources];

        for (int i = 0; i < processes; i++) {
            for (int j = 0; j < resources; j++) {

                need[i][j] = MAX[i][j] - allocation[i][j];
            }
        }


        for (int k = 0; k < 5; k++) {

            for (int i = 0; i < processes; i++) {

                if (F[i] == 0) {

                    int flag = 0;

                    for (int j = 0; j < resources; j++) {

                        if (need[i][j] > available[j]) {
                            flag = 1;
                            safe = 1;
                            break;
                        }
                    }

                    if (flag == 0) {
                        ans[ind++] = i;

                        for (int l = 0; l < resources; l++) {
                            available[l] += allocation[i][l];
                            F[i] = 1;

                        }

                    }
                }
            }
        }
        if(safe == 1){
            System.out.println("Processes are not safe!");
        }
        else{
        System.out.println("The Safe Sequence is as follows: ");
        for (int i = 0; i < processes; i++) {

            System.out.print("P" + ans[i] + " -> ");

        }
        }
    }
}
