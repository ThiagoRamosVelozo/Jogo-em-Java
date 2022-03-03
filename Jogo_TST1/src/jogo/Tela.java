package jogo;

import java.awt.Color;          import java.awt.Graphics;
import javax.swing.JPanel;      import static jogo.Sprites.*;
import static jogo.Jogador.*;   import static jogo.Hitbox.itens;

public class Tela extends JPanel {
    
    public long time = 0;
    
    boolean[][][] sprites = generateAll();
    
    public synchronized void drawSprite(Graphics g, int index, int color, int x, int y){
        if(x < -15 || x > 500 || y < -15 || y > 500){return;} // Caso esteja fora da janela
        g.setColor(new Color(rgbs[color][0],rgbs[color][1],rgbs[color][2]));
        boolean[][] s = sprites[index];
        for (int i = 0; i < 16; i++){
            for (int j = 0; j < 16; j++){
                if (s[j][i]){
                    g.drawLine(x+i, y+j, x+i, y+j);
                }
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        for (int[] item : itens){
            drawSprite(g, item[2], item[3], 16*item[0] - J[0] + 240, 16*item[1] - J[1] + 240);
        }
        
        drawSprite(g, J[2], J[3], 240, 240);
        
        g.drawString("Itens: " + itens.size(), 10, 440);
        g.drawString("X: " + J[0] + "   Y: " + J[1] + "  M: " + J[4], 10, 460);
        
    }
    
}
