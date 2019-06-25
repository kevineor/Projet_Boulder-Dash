package entity.Road;

import entity.Blocks.Block;
import entity.asset.AssetRoad;

public class IntersectionBizarre extends Block {
    private static final int START_COL = 0;
    private static final int START_ROW= 1;


    public IntersectionBizarre (int x, int y) {
        super(x,y,AssetRoad.getInstance().getSprite(START_COL, START_ROW, 0)) ;
    }
    public IntersectionBizarre (int x, int y, int ROTATION)
    {
        super(x,y,AssetRoad.getInstance().getSprite(START_COL, START_ROW,ROTATION));
    }

}
