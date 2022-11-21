/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fifo;

/**
 *
 * @author Yash Bahekar
 */
import java.util.*;

public class FIFO {

    public static void main(String args[]) {

//        int incomingStream[] = {2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 5, 2};
        int incomingStream[] = {1,2,3,4,1,2,5,1,2,3,4,5};
        int pageFaults = 0;
        int pages = incomingStream.length;
        int top = 0;
        int frames = 3;

        int flag;
        int temp[] = new int[frames];

        for (int i = 0; i < frames; i++) {
            temp[i] = -1;
        }
        System.out.println("\n Frame 1 \t Frame 2 \tFrame 3");
        
        
//        case 1 hit
        for (int i = 0; i < pages; i++) {
            flag = 0;
            for (int j = 0; j < frames; j++) {

                if (temp[j] == incomingStream[i]) {
                    flag = 1;
                    break;
                }
            }
            
            
            // case 2 & 3 - pageFault  free space no space
            
            if(flag == 0){
                
                temp[top] = incomingStream[i];
                top++;
                pageFaults++;
                
                if(top >= frames){
                    top = 0;
                }
            }
            
            System.out.println();
            for(int j = 0;j<frames;j++){
                
                if(temp[j] != -1){
                    System.out.print(temp[j]+"\t\t");
                }
                else{
                    System.out.print("-\t\t");
                    
                }
            }
        }


        System.out.println("\n\n\tTotal Page Faults: "+ pageFaults);
    }
}
