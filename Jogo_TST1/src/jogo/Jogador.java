package jogo;

import java.util.ArrayList;
import static jogo.Hitbox.itens;

public class Jogador {
    
    public static int[] J = {-50, 50, 3, 1, 0};
    
    public static void move(){
        
        if ((J[4]&1)==1)J[1]-=2;
        if (((J[4]>>1)&1)==1)J[0]-=2;
        if (((J[4]>>2)&1)==1)J[1]+=2;
        if (((J[4]>>3)&1)==1)J[0]+=2;
        
    }
    
    public static void tecla(char c){
        
        switch(c){
                
            case 'q': J[2]--; break;
            case 'e': J[2]++; break;
                
            case 'z': J[3]--; break;
            case 'x': J[3]++; break;
                
            case 'r': itens.add(new int[]{(J[0]>>4), (J[1]>>4)-1, J[2], J[3], 0}); break;
            case 'y': itens.add(new int[]{(J[0]>>4), (J[1]>>4)-1, 13, 2, 1}); break;
            case 'u': itens.add(new int[]{(J[0]>>4), (J[1]>>4)-1,  9, 2, 2}); break;
            case 'i': itens.add(new int[]{(J[0]>>4), (J[1]>>4)-1, 14, 2, 3}); break;
            case 'j': itens.add(new int[]{(J[0]>>4), (J[1]>>4)-1, 15, 2, 7}); break;
            case 'p': itens.add(new int[]{(J[0]>>4), (J[1]>>4)-1, 12, 2, 5}); break;
            case 'X': itens.add(new int[]{(J[0]>>4), (J[1]>>4)-1, 13, 0, 6}); break;
                
            case '-': itens.remove(itens.size()-1); break;
            case 'k': J[0]=0; J[1]=0; break;
            case '0': itens = new ArrayList<>(); break;
            case '1': Serial.serialize(itens, "C:/Users/Usuario/Desktop/mapa.save"); break;
            case '2': itens = Serial.deserialize("C:/Users/Usuario/Desktop/mapa.save"); break;
                
            default:
                break;
            
        }
        
    }
    
}
