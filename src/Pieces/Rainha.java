package Pieces;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class Rainha extends Pieces {
    public Rainha(int location, int color) {
        super(location, color);
        
        try {img = ImageIO.read(new File("resource/rainha.png"));} catch (IOException e) {}
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

        for(int xpos = x + 1;xpos < 8; xpos++){
            try {if(Engine.Engine.board[xpos+y*8] != null && Engine.Engine.board[xpos+y*8].cor == cor)break;} catch (Exception e) {}
            v.add(moves(xpos, y));
            try {if(Engine.Engine.board[xpos+y*8] != null)break;} catch (Exception e) {}
        }
        for(int xpos = x - 1;xpos > -1; xpos--){
            try {if(Engine.Engine.board[xpos+y*8] != null && Engine.Engine.board[xpos+y*8].cor == cor)break;} catch (Exception e) {}
            v.add(moves(xpos, y));
            try {if(Engine.Engine.board[xpos+y*8] != null)break;} catch (Exception e) {}
        }
        
        for(int ypos = y+ 1;ypos < 8; ypos++){
            try {if(Engine.Engine.board[x+ypos*8] != null && Engine.Engine.board[x+ypos*8].cor == cor)break;} catch (Exception e) {}
            v.add(moves(x, ypos));
            try {if(Engine.Engine.board[x+ypos*8] != null)break;} catch (Exception e) {}
        }
        
        for(int ypos = y - 1;ypos > -1; ypos--){
            try {if(Engine.Engine.board[x+ypos*8] != null && Engine.Engine.board[x+ypos*8].cor == cor)break;} catch (Exception e) {}
            v.add(moves(x, ypos));
            try {if(Engine.Engine.board[x+ypos*8] != null)break;} catch (Exception e) {}
        }

        return v;
    }
}
