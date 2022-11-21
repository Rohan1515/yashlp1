/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package firstfit;

import java.util.*;

public class FirstFit{

    public static void main(String[] args){


      Scanner in = new Scanner(System.in);
      System.out.println("Enter No of processes: ");
      int process = in.nextInt();

      System.out.println("Enter No of blocks: ");
      int blocks = in.nextInt();

      int processSize[] = new int[process];
      int blockSize[] = new int[blocks];
      int FLAG[] = new int[blocks];
      
      for(int i =0;i<blocks;i++){
        FLAG[i] = 0;
      }

      for(int i = 0;i<process;i++){
        System.out.println("Enter size of process "+ (i+1)+" : ");
        processSize[i] = in.nextInt();
      }

      for(int i = 0;i<blocks;i++){
        System.out.println("Enter size of block "+ (i+1)+" : ");
        blockSize[i] = in.nextInt();
      }


      for(int i =0;i<process;i++){

            boolean flag = false;
            int BK = 0;

        for(int j =0;j<blocks;j++){

            if(FLAG[j] == 0 && processSize[i]<=blockSize[j]){

                FLAG[j] = 1;
                
                flag = true;
                BK = j;
                break;
            }
        }

        if(flag==true){
            System.out.println("Process "+(i+1)+" Allocated to Block "+(BK+1));
        }
        else{

            System.out.println("Process "+(i+1)+" Not Allocated!");
        }
      }


    }
}