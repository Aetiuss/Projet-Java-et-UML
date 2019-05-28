package model.entity;

public class Empty extends Entity{

    private char sprite = 'v';

    public Empty(int x, int y){
        super(x, y);
    }

    @Override
    public char getSprite() {
        return sprite;
    }
}
