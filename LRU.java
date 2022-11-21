/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lru;

/**
 *
 * @author Yash Bahekar
 */
public class LRU {

    /**
     * @param args the command line arguments
     */
    static int LRU(int time[],int f){
        
        int min = time[0];
        int pos = 0;
        
        for(int i =1; i < f;i++){
            if(time[i] < min){
                min = time[i];
                pos = i;
            }
        }
        
        
        return pos;
    }
    
    
    public static void main(String[] args) {

        
        
        int incomingStream[] = {2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 5, 2};
        int frames = 3;
        int pages = incomingStream.length;
        
        int Frame[] = new int[frames];
        int pageFault = 0;
        
        int time[] = new int[frames];
        int counter = 0;
        
        int flag1,flag2;
        int pos =0;
        
        for(int i = 0;i<frames;i++){
            Frame[i] = -1;
        }
        
        //case 1: page Hit
        System.out.println("Frame 1 \t Frame 2 \t Frame 3");
        for(int i = 0;i<pages;i++){
            
            flag1 = flag2 = 0;
            for(int j = 0;j<frames;j++){
                
                if(Frame[j] == incomingStream[i]){
                    
                    counter++;
                    time[j] = counter;
                    flag1 = flag2 = 1;
                    break;
                }
                
            }
            
            // case 2 PageFault free space
            if(flag1 == 0){
                
                for(int j = 0;j<frames;j++){
                    
                    if(Frame[j] == -1){
                        Frame[j] = incomingStream[i];
                        flag2 =1;
                        counter++;
                        pageFault++;
                        time[j] = counter;
                        break;
                    }
                    
                }
                
            }
            
            // case 3 Page fault and no free space...
            
            if(flag2 ==0){
                
                pos = LRU(time,frames);
                counter++;
                pageFault++;
                Frame[pos] = incomingStream[i];
                time[pos] = counter;
                
                
                
            }
            
            System.out.println("\t");
            for(int j = 0;j<frames;j++){
                System.out.print(Frame[j]+"\t\t");
            }
        }
        System.out.println("\n\n Total Page Faults: "+pageFault);
    }

}
