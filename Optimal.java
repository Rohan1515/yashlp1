/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package optimal;

/**
 *
 * @author Yash Bahekar
 */
public class Optimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int incomingStream[] = {2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 5, 2};
//        int incomingStream[] = {2,3,4,2,1,3,7,5,4,3};
        int pageFaults = 0;
        int frames = 3;
        int pages = incomingStream.length;

        int flag1, flag2, flag3;
        int max, pos = 0;
        int Frames[] = new int[frames];
        int temp[] = new int[frames];

        for (int i = 0; i < frames; i++) {
            Frames[i] = -1;
        }

//        for case Hit
        for (int i = 0; i < pages; i++) {

            flag1 = flag2 = 0;

            for (int j = 0; j < frames; j++) {

                if (Frames[j] == incomingStream[i]) {

                    flag1 = flag2 = 1;
                    break;
                }

            }
            
            // page fault  free space
            if(flag1 == 0){
                
                for(int j =0;j<frames;j++){
                    if(Frames[j] == -1){
                        pageFaults++;
                        Frames[j] = incomingStream[i];
                        flag2 = 1;
                        break;
                    }
                }
                
            }
            
            // no free space Optimal
            if(flag2 == 0){
                flag3 = 0;
                
                for(int j = 0; j<frames;j++){
                    
                    temp[j] = -1;
                    
                    for(int k = i+1; k<pages;k++){
                        
                        if(Frames[j] == incomingStream[k]){
                            temp[j] = k;
                            break;
                        }
                    }
                }
                
                for(int j = 0;j< frames;j++){
                    
                    if(temp[j] == -1){
                        pos = j;
                        flag3 = 1;
                        break;
                    }
                }
                
                if(flag3 == 0){
                    
                    max = temp[0];
                    pos = 0;
                    
                    for(int j =1;j<frames;j++){
                        
                        if(temp[j] > max){
                            max = temp[j];
                            pos = j;
                        }
                    }
                }
                
                Frames[pos] = incomingStream[i];
                
            }

            System.out.println();
            for(int j = 0;j<frames;j++){
                System.out.print(Frames[j] + "\t");
            }
        }
        
        System.out.println("\n\nTotal Page Faults : "+ pageFaults);

    }

}
