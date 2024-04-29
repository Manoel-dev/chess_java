package Pieces;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class Rei extends Pieces{
    public Rei(int location, int color) {
        super(location, color);
        
        try {img = ImageIO.read(new File("resource/rei.png"));} catch (IOException e) {}
    }

    @Override
    public Vector<int[]> drawMoves(){
        Vector<int[]> v = new Vector<int[]>();

        for(int a = 0; a < 3; a++){
            int xpos = x-1 + a;
            try {if(Engine.Engine.board[xpos+(y+1)*8] == null){v.add(moves(xpos, y + 1));} else if(Engine.Engine.board[xpos+(y+1)*8].cor != cor)v.add(moves(xpos, y + 1));} catch (Exception e) {}
            try {if(Engine.Engine.board[xpos+(y-1)*8] == null){v.add(moves(xpos, y - 1));} else if(Engine.Engine.board[xpos+(y-1)*8].cor != cor)v.add(moves(xpos, y - 1));} catch (Exception e) {}
        }
        try {if(Engine.Engine.board[x-1+y*8] == null){v.add(moves(x - 1, y));} else if(Engine.Engine.board[x-1+y*8].cor != cor){v.add(moves(x - 1, y));}} catch (Exception e) {}
        try {if(Engine.Engine.board[x+1+y*8] == null){v.add(moves(x + 1, y));} else if(Engine.Engine.board[x+1+y*8].cor != cor){v.add(moves(x + 1, y));}} catch (Exception e) {}

        return v;
    }
}
