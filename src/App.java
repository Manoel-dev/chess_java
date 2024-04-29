
import javax.swing.JFrame;

import Engine.Engine;
import Pieces.Pieces;

public class App extends JFrame {

    void start(){
        setTitle("Chess Branco");
        setContentPane(new Engine());
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        

        Engine.fenChess("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", this);
        setVisible(true);

        while (true) {
            if(Pieces.updateGame){
                repaint();
                setTitle("Chess " + ((Engine.cor == 0) ? "Branco" : "Preto"));
                Pieces.updateGame=false;
            } else {
                for (Pieces pieces : Engine.board) {
                    if(pieces != null && pieces.isSelect && Engine.verficacao){
                        Engine.selectPieces = pieces;
                        Engine.verficacao = false;
                        repaint();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new App().start();
    }
}
