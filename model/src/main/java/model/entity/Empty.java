package model.entity;

public class Empty extends Entity{

    private char sprite = 'v';

    public Empty(int x, int y,Entity[][] map){
        super(x, y, map);
    }

    @Override
    public char getSprite() {
        return sprite;
    }
}
