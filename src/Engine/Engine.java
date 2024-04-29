package Engine;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Pieces.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Engine extends JPanel {
    
    public static Pieces selectPieces;
    public static int cor = 0;
    private Color corClara = new Color(237, 237, 208);
    private Color corEscua = new Color(116, 150, 75);
    public static Pieces[] board = new Pieces[64];
    public static boolean verficacao = true;

    public Engine(){
        setPreferredSize(new Dimension(600, 600));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                Color paintColor = ((x - y) % 2 != 0) ? corClara : corEscua;
                g.setColor(paintColor);
                g.fillRect(x * 75, y * 75 , 75, 75);
            }  
        }  
        
        if(selectPieces != null && selectPieces.isSelect){
            for (int[] paintPoints : selectPieces.drawMoves()) {
                g.setColor(new Color(0, 155, 196));
                int position = paintPoints[0]+paintPoints[1]*8;
                    
                try{if(board[position] != null) g.setColor(new Color(255, 0, 0));} catch (Exception e) {}
                g.fillRect(paintPoints[0]*75, paintPoints[1]*75, 75, 75);
            }
        }
    }

    public static void fenChess(String text, JFrame game){
        int position = 0;
        for (char t : text.toCharArray()) {
            switch (t) {
                case 'p':
                    board[position] = new Peao(position, Pieces.BRANCO);
                    break;
                case 'r':
                    board[position] = new Torre(position, Pieces.BRANCO);
                    break;
                case 'n':
                    board[position] = new Cavalo(position, Pieces.BRANCO);
                    break;
                case 'b':
                    board[position] = new Bispo(position, Pieces.BRANCO);
                    break;
                case 'q':
                    board[position] = new Rainha(position, Pieces.BRANCO);
                    break;
                case 'k':
                    board[position] = new Rei(position, Pieces.BRANCO);
                    break;
                case 'P':
                    board[position] = new Peao(position, Pieces.PRETO);
                    break;
                case 'R':
                    board[position] = new Torre(position, Pieces.PRETO);
                    break;
                case 'N':
                    board[position] = new Cavalo(position, Pieces.PRETO);
                    break;
                case 'B':
                    board[position] = new Bispo(position, Pieces.PRETO);
                    break;
                case 'Q':
                    board[position] = new Rainha(position, Pieces.PRETO);
                    break;
                case 'K':
                    board[position] = new Rei(position, Pieces.PRETO);
                    break;
                default:
                    break;
            }
            if(t != '/'){position++;}
            try {position += Integer.parseInt(String.valueOf(t)) -1;} catch (Exception e) {}
            
        }
        for (Pieces pieces : board) {try {game.add(pieces);} catch (Exception e) {}}
    }
}
