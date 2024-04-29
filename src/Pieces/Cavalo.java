package Pieces;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class Cavalo extends Pieces {
    public Cavalo(int location, int color) {
        super(location, color);
        
        try {img = ImageIO.read(new File("resource/cavalo.png"));} catch (IOException e) {}
    }

    @Override
    public Vector<int[]> drawMoves(){
        Vector<int[]> v = new Vector<int[]>();

        v.add(moves(x -1, y -2));
        v.add(moves(x +1, y -2));
        v.add(moves(x -2, y -1));
        v.add(moves(x +2, y -1));

        v.add(moves(x -1, y +2));
        v.add(moves(x +1, y +2));
        v.add(moves(x -2, y +1));
        v.add(moves(x +2, y +1));

        for(int a = 0; a < v.size();a++){
            try {  
            if(Engine.Engine.board[v.get(a)[0]+v.get(a)[1]*8].cor == cor){
                v.remove(a);
                a--;
            }
            } catch (Exception e) {
            }
        }
        
        return v;
    }
}
