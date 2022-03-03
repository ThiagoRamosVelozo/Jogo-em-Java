package jogo;

import java.util.ArrayList;
import static jogo.Jogador.*;

public class Hitbox {
    
    // X, Y, Sprite, Cor, Reação
    public static ArrayList<int[]> itens = new ArrayList<>();
    
    public static Collision[] col = {
        (a,d) -> {},
        (a,d) -> {switch(d){case'w':jy-=32;break;case's':jy+=32;break;}},
        (a,d) -> {switch(d){case'a':a[0]--;break;case'w':a[1]--;break;case'd':a[0]++;break;case's':a[1]++;break;}},
        (a,d) -> {if(d=='?'||d=='d')jx+=3;},
        (a,d) -> {jx=0;jy=0;}
    };
    
    public static boolean hit(int x1, int y1, int x2, int y2){
        
        return
                x1 < x2 + 14 &&
                x1 + 14 > x2 &&
                y1 < y2 + 14 &&
                y1 + 14 > y2
                ;
    }
    
    public synchronized static void check(){
        
        for (int[] item : itens){
            
            if (hit(jx, jy, item[0]<<4, item[1]<<4))col[item[4]].on(item, '?');
            
            if (hit(jx-2, jy, item[0]<<4, item[1]<<4) && mov.contains('a')){
                mov.remove((Character)'a'); //parede[0]--;
                col[item[4]].on(item, 'a');
            } else
            
            if (hit(jx, jy-2, item[0]<<4, item[1]<<4) && mov.contains('w')){
                mov.remove((Character)'w'); //parede[1]--;
                col[item[4]].on(item, 'w');
            } else
            
            if (hit(jx+2, jy, item[0]<<4, item[1]<<4) && mov.contains('d')){
                mov.remove((Character)'d'); //parede[0]++;
                col[item[4]].on(item, 'd');
            } else
            
            if (hit(jx, jy+2, item[0]<<4, item[1]<<4) && mov.contains('s')){
                mov.remove((Character)'s'); //parede[1]++;
                col[item[4]].on(item, 's');
            }
        }
        
    }
    
}
