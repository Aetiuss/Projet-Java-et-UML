package model.entity;

import model.entity.entityBehaviours.FallableDestrutable;
import model.entity.entityBehaviours.IDestructable;

public class Wall extends Entity
{
    
    IDestructable destructable;
    private char sprite = 'w';

    public Wall(int x, int y, Entity[][] map)
    {
        super(x, y, map);
        destructable = new FallableDestrutable();
    }

    @Override
    public char getSprite() {
        return sprite;
    }
    
}
