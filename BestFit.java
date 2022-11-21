/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bestfit;

import java.util.*;

/**
 *
 * @author Yash Bahekar
 */
public class BestFit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Emter No of Processes: ");
        int process = in.nextInt();
        
        System.out.println("Enter No of Blocks");
        int blocks = in.nextInt();
        
        int processSize[] = new int[process];
        int blockSize[] = new int[blocks];
        int FLAG[] = new int[blocks];
        
        for(int i = 0 ; i < blocks; i++){
            FLAG[i] = 0;
        }
        
        for(int i = 0; i< process;i++){
            System.out.println("Enter size of process "+(i+1)+" : ");
            processSize[i] = in.nextInt();
        }
        
        
        for(int i = 0; i< blocks;i++){
            System.out.println("Enter size of block "+(i+1)+" : ");
            blockSize[i] = in.nextInt();
        }
        
        for(int i = 0 ; i< process;i++){
            
            int diff = Integer.MAX_VALUE;
            int BK = 0;
            boolean flag = false;
            
            for(int j = 0 ; j < blocks;j++){
                
                if(FLAG[j] == 0 && processSize[i] <= blockSize[j]){
                    
                    int temp = blockSize[j] - processSize[i];
                    
                    if(temp < diff){
                        diff = temp;
                        BK = j;
                        flag = true;
                    }
                    
                }
            }
            
            if(flag){
                FLAG[BK] = 1;
                System.out.println("Process "+(i+1)+" Allocated to Block "+(BK+1));
            }else{
                System.out.println("Process "+(i+1)+" Not Allocated!!!"+(BK+1));
                
            }
        }
        
        
        

    }

}
