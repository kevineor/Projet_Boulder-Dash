package entity.Road;

import entity.Blocks.Block;
import entity.asset.AssetRoad;

public class Intersection extends Block {
    private static final int START_COL = 2;
    private static final int START_ROW= 0;


    public Intersection (int x, int y) {
        super(x,y,AssetRoad.getInstance().getSprite(START_COL, START_ROW, 0)) ;
    }

}
