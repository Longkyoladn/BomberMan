package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.move.CheckMove;

public class Flameitem extends Entity {
    public Flameitem(int x, int y, Image img) {
        super(x,y,img);
    }

    @Override
    public void update() {
        if(pick()) {
            this.remove();
        }
    }

    public boolean pick() {
        for(Entity e : BombermanGame.entities) {
            if( e instanceof Bomber && CheckMove.intersects(this,e)) {
                ((Bomber) e).setLength(((Bomber) e).getLength() + 1);
                return true;
            }
        }
        return false;
    }
}
