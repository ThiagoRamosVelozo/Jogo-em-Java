package jogo;

import java.util.ArrayList;
import static jogo.Hitbox.itens;

public class Jogador {
    
    public static int jx = -50, jy = -50, spr = 3, clr = 1;
    
    public static ArrayList <Character> mov = new ArrayList<>();
    
    public static void tecla(char c){
        
        switch(c){
            
            case 'd': // LESTE
                jx++;
                break;
                
            case 'a': // OESTE
                jx--;
                break;
                
            case 'w': // NORTE
                jy--;
                break;
                
            case 's': // SUL
                jy++;
                break;
                
            case 'q':
                spr--;
                break;
                
            case 'e':
                spr++;
                break;
                
            case 'z':
                clr--;
                break;
                
            case 'x':
                clr++;
                break;
                
            case 'r':
                itens.add(new int[]{(jx>>4), (jy>>4)-1, spr, clr, 0});
                break;
                
            case 'y':
                itens.add(new int[]{(jx>>4), (jy>>4)-1, 13, 2, 1});
                break;
                
            case 'u':
                itens.add(new int[]{(jx>>4), (jy>>4)-1, 9, 2, 2});
                break;
                
            case 'i':
                itens.add(new int[]{(jx>>4), (jy>>4)-1, 14, 2, 3});
                break;
                
            case '-':
                itens.remove(itens.size()-1);
                break;
                
            case '0':
                itens = new ArrayList<>();
                break;
                
            case '1':
                Serial.serialize(itens, "C:/Users/Usuario/Desktop/mapa.save");
                break;
                
            case '2':
                itens = Serial.deserialize("C:/Users/Usuario/Desktop/mapa.save");
                break;
                
            default:
                break;
            
        }
        
    }
    
}
