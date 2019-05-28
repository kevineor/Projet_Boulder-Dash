package model.asset;

/**
 * The AssetPerso class
 *
 * @author Kevin
 * @version $Id: $Id
 */
//Singleton contenant le sprite des blocks
public class AssetPerso extends SpriteAsset {


    private static AssetPerso ourInstance = new AssetPerso();

    /**
     * <p>getInstance.</p>
     *
     * @return a {@link model.asset.AssetPerso} object.
     */
    public static AssetPerso getInstance() {
        return ourInstance;
    }

    /**
     *
     *
     */
    private AssetPerso()
    {
        super("assets/Perso.png");
    }


}
