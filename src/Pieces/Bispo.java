package Pieces;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class Bispo extends Pieces {

    public Bispo(int location, int color) {
        super(location, color);
        try {img = ImageIO.read(new File("resource/bispo.png"));} catch (IOException e) {}
    }

    @Override
    public Vector<int[]> drawMoves(){
        Vector<int[]> v = new Vector<int[]>();

        int ya = y;
        for(int a = x+1; a < 8;a++){
            ya+=1;
            try {if(Engine.Engine.board[a+ya*8] != null && Engine.Engine.board[a+ya*8].cor == cor)break;} catch (Exception e) {}
            v.add(moves(a, ya));
            try {if(Engine.Engine.board[a+ya*8] != null)break;} catch (Exception e) {}
        }
        ya = y;
        for(int a = x-1; a >= 0;a--){
            ya-=1;
            if(ya < 0)break;
            try {if(Engine.Engine.board[a+ya*8] != null && Engine.Engine.board[a+ya*8].cor == cor)break;} catch (Exception e) {}
            v.add(moves(a, ya));
            try {if(Engine.Engine.board[a+ya*8] != null)break;} catch (Exception e) {}
        }
        ya = y;
        for(int a = x-1; a >= 0;a--){
            ya+=1;
            if(ya >= 8)break;
            try {if(Engine.Engine.board[a+ya*8] != null && Engine.Engine.board[a+ya*8].cor == cor)break;} catch (Exception e) {}
            v.add(moves(a, ya));
            try {if(Engine.Engine.board[a+ya*8] != null)break;} catch (Exception e) {}
        }
        ya = y;
        for(int a = x+1; a < 8;a++){
            ya-=1;
            if(ya < 0)break;
            try {if(Engine.Engine.board[a+ya*8] != null && Engine.Engine.board[a+ya*8].cor == cor)break;} catch (Exception e) {}
            v.add(moves(a, ya));
            try {if(Engine.Engine.board[a+ya*8] != null)break;} catch (Exception e) {}
        }


        return v;
    }
}
