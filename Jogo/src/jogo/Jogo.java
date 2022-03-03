package jogo;

public class Jogo {

    public static void main(String[] args) {
        
        for (int i = 0; i < 500; i++){
            Hitbox.itens.add(new int[]{i, -5 - i%2, 4, 1, 0});
            Hitbox.itens.add(new int[]{i, 0, 14, 2, 3});
            Hitbox.itens.add(new int[]{i, 5 + i%2, 4, 1, 0});
        }
        
        Hitbox.itens.add(new int[]{500, 0, 2, 2, 4});
        
        new Janela();
        
    }
    
}
