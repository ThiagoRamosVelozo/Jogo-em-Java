package jogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import static jogo.Hitbox.check;
import static jogo.Jogador.*;

public class Janela extends JFrame {
    
    Container c;
    Tela tela = new Tela();
    
    Timer motor = new Timer(10, (ActionEvent ae) -> {
        tela.repaint();
        tela.time++;
        
        check();
        
        for (char c : mov){
            tecla(c);
        }
        
    });

    public Janela() {
        c = getContentPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        c .add( tela, BorderLayout.CENTER );
        motor.start();
        
        tela.setBackground(Color.BLACK);
        
        addKeyListener( new KeyListener(){
            
            @Override public void keyTyped(KeyEvent ke) {
                ke.consume();
            }
            
            @Override public void keyPressed(KeyEvent ke) {
                
                Character c = ke.getKeyChar();
                
                if ("wasd".contains(""+c) && !mov.contains( ke .getKeyChar() ) ){
                    mov.add(c);
                    
                } else {
                    tecla(c);
                }
                
            }
            @Override public void keyReleased(KeyEvent ke) {
                
                mov .remove( (Character) ke .getKeyChar() );
            }
        } );
        
        setSize(512, 512);
        setResizable(false);
        setVisible(true);
    }
    
}
