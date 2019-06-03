package model.entity.entityBehaviours;

import contract.showboard.BoardFrame;
import model.Map;
import model.entity.Diamond;
import model.entity.Empty;
import model.entity.Entity;
import model.entity.Player;

public class Fallable
{
    
    /**
     * this boolean is used to prevent the player from being squished when under a rock with no momentum
     */
    boolean falling = false;
    /**
     * the entity variable is used to allow the fallable class access to the variables of entity such as x, y, or map
     */
    public Entity entity;
    
    public Fallable(Entity entity)
    {
        this.entity = entity;
    }
    
    /**
     * the method simply checks if the fallable object can go downwards and moves it and sets its falling bool to true. It resets it to false when it can no longer fall any further
     */
    public void fall()
    {
        if (Map.getInstance()
               .getMap()[entity.x][entity.y + 1].getSprite() == 'v')
        {
            Map.getInstance()
               .getMap()[entity.x][entity.y] = new Empty(entity.x, entity.y, entity.map);
            entity.y++;
            setFalling(true);
            Map.getInstance()
               .getMap()[entity.x][entity.y] = entity;
        }
        else if (Map.getInstance()
                    .getMap()[entity.x][entity.y + 1].getSprite() == 'p')
        {
            try
            {
                if (Map.getInstance()
                       .getMap()[entity.x][entity.y].fallable.falling == true)
                {
                    Player.getInstance()
                          .die();
                    BoardFrame.kill(); //kill from BoardFrame
                }
            }
            catch (Exception e)
            {
                System.out.print("");
            }
            
        }
        else
        {
            try
            {
                Map.getInstance()
                   .getMap()[entity.x][entity.y].fallable.setFalling(false);
            }
            catch (final Exception e)
            {
                System.out.print("");
            }
        }
        try
        {
            if (Map.getInstance()
                   .getMap()[entity.x][entity.y].fallable.falling)
            {
                if (Map.getInstance()
                       .getMap()[entity.x][entity.y + 1].getSprite() == 'f' || Map.getInstance()
                                                                                  .getMap()[entity.x][entity.y + 1].getSprite() == 'd')
                {
                    if (Map.getInstance()
                           .getMap()[entity.x - 1][entity.y + 1].getSprite() == 'v' && Map.getInstance()
                                                                                          .getMap()[entity.x - 1][entity.y].getSprite() == 'v')
                    {
                entity.pushable.pushLeft();
            }
                    if (Map.getInstance()
                           .getMap()[entity.x + 1][entity.y + 1].getSprite() == 'v' && Map.getInstance()
                                                                                          .getMap()[entity.x + 1][entity.y].getSprite() == 'v')
                    {
                entity.pushable.pushRight();
            }
                }
            }
        }
        catch (Exception e) {}
        if (Map.getInstance()
               .getMap()[entity.x][entity.y + 1].getSprite() == 'm')
        {
            for (int i = 2; i >= 0; i--)
            {
                for (int j = 2; j >= 0; j--)
                {
                    Map.getInstance()
                       .getMap()[entity.x - 1 + i][entity.y + j] = new Empty(entity.x + i, entity.y - 1 + j, Map.getInstance()
                                                                                                                .getMap());
                    Map.getInstance()
                       .getMap()[entity.x - 1 + i][entity.y + j] = new Diamond(entity.x + i, entity.y - 1 + j, Map.getInstance()
                                                                                                                  .getMap());
                }
            }
        }
    }
    
    /**
     * set the falling attribute
     */
    void setFalling(boolean b)
    {
        falling = b;
    }
    
}