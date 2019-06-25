package entity.asset;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The class AssetBlocks
 *
 * It is a singleton which contains all blocks assets
 *
 * @author Kevin
 * @version $Id: $Id
 */
public class AssetRoad extends SpriteAsset {

    private static AssetRoad ourInstance = new AssetRoad();

    /**
     * <p>getInstance.</p>
     *
     * @return a {@link entity.asset.AssetBlocks} object.
     */
    public static AssetRoad getInstance() {
        return ourInstance;
    }

    private AssetRoad()
    {
        super("D:\\Dev\\Java\\Projet_Boulder-Dash\\model\\src\\main\\resources\\assets\\road.jpg");
    }

    public BufferedImage getSprite(int x, int y, int rotation) {
        return rotate(super.getSprite(x, y), rotation);
    }

    public static BufferedImage rotate(BufferedImage bimg, int rotation){
        int w = bimg.getWidth();
        int h = bimg.getHeight();
        Graphics2D graphic = bimg.createGraphics();
        graphic.rotate(Math.toRadians(rotation * 90), w/2, h/2);
        graphic.drawImage(bimg, null, 0, 0);
        graphic.dispose();
        return bimg;
    }
}
