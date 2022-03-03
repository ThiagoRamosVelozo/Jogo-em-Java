package jogo;

import java.awt.Desktop;    import java.io.IOException;
import java.net.URI;        import java.util.ArrayList;
import static jogo.Jogador.*;

public class Hitbox {
    
    // X, Y, Sprite, Cor, Reação
    public static ArrayList<int[]> itens = new ArrayList<>();
    
    public static Collision[] col = {
        (a,d) -> {},
        (a,d) -> {switch(d){case'w':J[1]-=32;break;case's':J[1]+=32;break;}},
        (a,d) -> {switch(d){case'a':a[0]--;break;case'w':a[1]--;break;case'd':a[0]++;break;case's':a[1]++;break;}},
        (a,d) -> {if(d=='?'||d=='d')J[0]+=3;},
        (a,d) -> {J[0]=0;J[1]=0;},
        (a,d) -> {
            if(d=='w'){
                try{
                    Desktop.getDesktop().browse(URI.create("https://pt.wikihow.com/Página-principal"));
                } catch(IOException ex) {a[3] = 0;}
            }
        },
        (a,d) -> { System.exit(0); },
        (a,d) -> {if(d=='?'||d=='s')J[1]+=3;}
    };
    
    public static boolean hit(int x1, int y1, int x2, int y2){
        return x1 < x2 + 14 && x1 + 14 > x2 && y1 < y2 + 14 && y1 + 14 > y2;
    }
    
    public synchronized static void check(){
        
        for (int[] item : itens){
            if (hit(J[0], J[1], item[0]<<4, item[1]<<4))col[item[4]].on(item, '?');
            if (hit(J[0]-2, J[1], item[0]<<4, item[1]<<4) && ((J[4]>>1)&1)==1){ J[4]&=~(1<<1); col[item[4]].on(item, 'a');
            } else if (hit(J[0], J[1]-2, item[0]<<4, item[1]<<4) && (J[4]&1)==1){ J[4]&=~1; col[item[4]].on(item, 'w');
            } else if (hit(J[0]+2, J[1], item[0]<<4, item[1]<<4) && ((J[4]>>3)&1)==1){ J[4]&=~(1<<3); col[item[4]].on(item, 'd');
            } else if (hit(J[0], J[1]+2, item[0]<<4, item[1]<<4) && ((J[4]>>2)&1)==1){ J[4]&=~(1<<2); col[item[4]].on(item, 's'); }
        }
        
    }
    
}
