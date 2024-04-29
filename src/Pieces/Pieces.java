package Pieces;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JComponent;

import Engine.Engine;

public abstract class Pieces extends JComponent {

    public final static int BRANCO = 0;
    public final static int PRETO = 1;

    public int x = 0, 
               y = 0, 
               mouseInputX = 0, 
               mouseInputY = 0;
    
    int cor;
    Image img = null;

    Boolean firstMove = true;
    public Boolean isSelect = false;
    public static Boolean updateGame = false;

    public Pieces(int location, int color){
        y = location /8 ;
        x = location % 8 ;
        this.cor = color;

        setLayout(null);
        setBounds (x*75,y*75,75,75);
        
        MouseAdapter mouse = new MouseAdapter () {
            
            @Override
            public void mouseDragged(MouseEvent e) { 
                if(cor == Engine.cor){
                    isSelect = true;
        
                    mouseInputX = e.getXOnScreen() - 40;
                    mouseInputY = e.getYOnScreen() - 60;

                    setLocation(mouseInputX, mouseInputY);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                for (int[] pointsMoves : drawMoves()) {
                    if(pointsMoves[0] == (mouseInputX+40) /75 && pointsMoves[1] == (mouseInputY+60) /75){
                        Engine.board[x+y*8] = null;
                        Update(pointsMoves);
                        firstMove = false;

                        x = (mouseInputX+40) /75;
                        y = (mouseInputY+60) /75;
                        
                        Engine.cor = (Engine.cor == 1) ? 0 : 1;
                        break;
                    }
                }
                setLocation(x * 75, y * 75);
                
                Engine.board[x+y*8] = Pieces.this;
                Engine.verficacao = true;
                updateGame =true;
                isSelect = false;
                
            }
        };

        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    public void Update(int[] point){
        int location = point[0]+point[1]*8;
        if(Engine.board[location] != null  && Engine.board[location] != this && Engine.board[location].x == this.x && Engine.board[location].y == this.y)
        {
            Engine.board[location].setVisible(false);
        }
    }

    public abstract Vector<int[]> drawMoves();
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getimg(), 0, 0, 75, 75, null);
        
    }

    protected int[] moves(int x, int y){
        return new int[]{x,y};
    }

    public Image getimg() {
        // Transforma a imagem num buffer onde poderar ser pintado
        BufferedImage imgPeca = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        imgPeca.getGraphics().drawImage(img, 0, 0, null);

        // Se definimos a cor da peça como preto sera executado esse loop para pintar a peça
        if(cor == PRETO){
            for (int x = 0; x < imgPeca.getWidth(); x++) {
                for (int y = 0; y < imgPeca.getHeight(); y++) {
                    int rgba = (imgPeca.getRGB(x, y) == 0) ? 0 : (imgPeca.getRGB(x, y) < -16000000) ? -16777216 : -14013910;
                    imgPeca.setRGB(x, y, rgba);
                }
            }
        }
        return imgPeca;
    }
}
