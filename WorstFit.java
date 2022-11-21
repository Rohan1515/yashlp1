/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package worstfit;

import java.util.*;

/**
 *
 * @author Yash Bahekar
 */
public class WorstFit {

    /**
     * @param args the command line arguments
     */
    public static void swap(int a[], int s1, int s2) {
        int temp = a[s1];
        a[s1] = a[s2];
        a[s2] = temp;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner in = new Scanner(System.in);

        System.out.println("Enter No of Processes: ");
        int process = in.nextInt();
        System.out.println("Enter No of Blocks: ");
        int blocks = in.nextInt();

        int id[] = new int[process];
        int processSize[] = new int[process];
        int blockSize[] = new int[blocks];
        int FLAG[] = new int[blocks];

        for (int i = 0; i < blocks; i++) {
            FLAG[i] = 0;
        }

        for (int i = 0; i < process; i++) {
            System.out.println("Enter size of process " + (i + 1) + " : ");
            processSize[i] = in.nextInt();
            id[i] = i + 1;
        }

        for (int i = 0; i < blocks; i++) {
            System.out.println("Enter size of block " + (i + 1) + " : ");
            blockSize[i] = in.nextInt();
        }

        for (int i = 0; i < process; i++) {
            for (int j = 0; j < process - (i + 1); i++) {

                if (processSize[j] > processSize[j + 1]) {

                    swap(processSize, j, j + 1);
                    swap(id, j, j + 1);
                }
            }
        }

        for (int i = 0; i < process; i++) {

            int diff = Integer.MIN_VALUE;
            int BK = 0;
            boolean flag = false;

            for (int j = 0; j < blocks; j++) {

                if (FLAG[j] == 0 && processSize[i] <= blockSize[j]) {

                    int temp = blockSize[j] - processSize[i];

                    if (temp > diff) {
                        diff = temp;
                        BK = j;
                        flag = true;
                    }
                }

            }

            if (flag) {
                FLAG[BK] = 1;
                System.out.println("Process " + (i + 1) + " Allocated to Block " + (BK + 1));

            } else {
                System.out.println("Process " + (i + 1) + " Not Allocated ");

            }
        }


    }

}
