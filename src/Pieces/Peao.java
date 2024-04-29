package Pieces;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import Engine.Engine;

public class Peao extends Pieces {

    public Peao(int location, int color) {
        super(location, color);
        try {img = ImageIO.read(new File("resource/Pawn.png"));} catch (IOException e) {}
    }
    
    @Override
    public Vector<int[]> drawMoves(){
        Vector<int[]> v = new Vector<int[]>();
        try {
            
        if(firstMove && Engine.board[(this.cor == BRANCO) ? x+y*8+8 : x+y*8-8] == null && Engine.board[(this.cor == BRANCO) ? x+y*8+16 : x+y*8-16] == null){
            v.add(moves(x, y + ((this.cor == BRANCO) ? + 1 : -1)));
            v.add(moves(x, y + ((this.cor == BRANCO) ? + 2 : -2)));
            } else if (Engine.board[(this.cor == BRANCO) ? x+y*8+8 : x+y*8-8] == null) {
                v.add(moves(x,y + ((this.cor == BRANCO) ? + 1 : -1)));
            }
        } catch (Exception e) {}
        try {
            if(Engine.board[(this.cor == BRANCO) ? x+1+y*8+8 : x+1+y*8-8] != null && Engine.board[(this.cor == BRANCO) ? x+1+y*8+8 : x+1+y*8-8].cor != cor){v.add(moves(x+1,y + ((this.cor == BRANCO) ? + 1 : -1)));}
        } catch (Exception e) {}

        try {
            if(Engine.board[(this.cor == BRANCO) ? x-1+y*8+8 : x-1+y*8-8] != null && Engine.board[(this.cor == BRANCO) ? x-1+y*8+8 : x-1+y*8-8].cor != cor){v.add(moves(x-1,y + ((this.cor == BRANCO) ? + 1 : -1)));}
        } catch (Exception e) {}
        return v;
    }
}
