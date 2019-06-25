package entity.Road;

import entity.Blocks.Block;
import entity.asset.AssetRoad;

public class Vide extends Block {
    private static final int START_COL = 3;
    private static final int START_ROW = 0;
    private static final int ROTATION = 0;

    /**
     * The ennemy constructor
     *
     * @param x a int.
     * @param y a int.
     */
    public Vide(int x, int y) {
        super(x,y,AssetRoad.getInstance().getSprite(START_COL, START_ROW, ROTATION));
    }
}
