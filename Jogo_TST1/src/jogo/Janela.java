package jogo;

import java.awt.BorderLayout;       import java.awt.Color;
import java.awt.Container;          import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;     import java.awt.event.KeyListener;
import javax.swing.JFrame;          import javax.swing.Timer;
import static jogo.Hitbox.check;    import static jogo.Jogador.*;

public class Janela extends JFrame {
    
    Container c;
    Tela tela = new Tela();
    
    Timer motor = new Timer(10, (ActionEvent ae) -> {
        tela.repaint();
        tela.time++;
        
        check();
        Jogador.move();
        
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
                
                char c = ke.getKeyChar(); int i = "wasd".indexOf(c);
                if(i>-1){ J[4]|=1<<i; } else { tecla(c); ke.consume(); }
                
            }
            @Override public void keyReleased(KeyEvent ke) {
                
                char c = ke.getKeyChar(); int i = "wasd".indexOf(c);
                if(i>-1){ J[4]&=~(1<<i); }
                
            }
        } );
        
        tela.setFont( new Font("Old English Text MT", Font.BOLD, 20) );
        
        setSize(512, 512);
        setResizable(false);
        setVisible(true);
    }
    
}
