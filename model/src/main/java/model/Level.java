package model;

import contract.IModel;
import entity.Blocks.*;
import entity.Direction;
import entity.GameProperties;
import entity.Road.*;

import java.awt.*;
import java.util.Observable;

/**
 * The Level class
 * It's a model that contain a map which describes the actual game state
 *
 * @author Kevin
 * @version $Id: $Id
 */
public class Level extends Observable implements IModel {
    private Block[][] map;

    /**
     * <p>Getter for the field <code>tailleMapX</code>.</p>
     *
     * @return a int.
     */
    public int getTailleMapX() {
        return tailleMapX;
    }

    /**
     * <p>Getter for the field <code>tailleMapY</code>.</p>
     *
     * @return a int.
     */
    public int getTailleMapY() {
        return tailleMapY;
    }

    /** {@inheritDoc} */
    @Override
    public void setChanged() {
        super.setChanged();
    }

    private int tailleMapX;
    private int tailleMapY;

    /**
     * <p>Getter for the field <code>playerX</code>.</p>
     *
     * @return a int.
     */
    public int getPlayerX() {
        return playerX;
    }

    /** {@inheritDoc} */
    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    private int playerX;

    /**
     * <p>Getter for the field <code>playerY</code>.</p>
     *
     * @return a int.
     */
    public int getPlayerY() {
        return playerY;
    }

    /** {@inheritDoc} */
    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    /** {@inheritDoc} */
    public void setPlayerPos(int playerX, int playerY)
    {
        this.setPlayerX(playerX);
        this.setPlayerY(playerY);
        ((Player)this.getBlock(playerX, playerY)).setMooving(true);
    }

    private int playerY;

    /**
     * The Level default constructor
     */
    public Level()
    {
        init();
    }

    /**
     *
     * The charged level constructor
     *
     * @param s the level
     */
    public Level(String s)
    {
        init();
        System.out.println(s);
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++)
        {
            switch (s.charAt(i))
            {

                case 'a':
                    map[x][y] = new Intersection(x,y);
                    break;

                case 'b':
                    map[x][y] = new Horizontal(x,y);
                    break;

                case 'c':
                    map[x][y] = new Vertical(x,y);
                    break;

                case 'd':
                    map[x][y] = new Vide(x,y);
                    break;
                case'e': // bas vers gauche
                    map[x][y] = new Tourner(x,y,0);
                    break;
                case'f': // gauche vers haut
                    map[x][y] = new Tourner(x,y,1);
                    break;
                case'g': // haut vers droite
                    map[x][y] = new Tourner(x,y,2);
                    break;
                case'h': // droite vers bas
                    map[x][y] = new Tourner(x,y,3);
                    break;
                case'i': // gauche vers haut
                    map[x][y] = new IntersectionBizarre(x,y,0);
                    break;
                case'j': // gauche vers haut
                    map[x][y] = new IntersectionBizarre(x,y,1);
                    break;
                case'k': // gauche vers haut
                    map[x][y] = new IntersectionBizarre(x,y,2);
                    break;
                case'l': // gauche vers haut
                    map[x][y] = new IntersectionBizarre(x,y,3);
                    break;
                case 'W':
                    map[x][y] = new Wall(x, y);
                    break;
                case 'D':
                    map[x][y] = new Dirt(x, y);
                    break;
                case 'P':
                    //personnage
                    map[x][y] = new Player(x, y);
                    this.playerX = x;
                    this.playerY = y;
                    break;
                case 'S':
                    map[x][y] = new Stone(x, y);
                    //stone
                    break;
                case 'O':
                    map[x][y] = new Diamond(x, y);
                    break;
                case 'E':
                    map[x][y] = new Ennemy(x, y);
                    break;
                case '\n':
                    y++;
                    x = -1;
                    break;
                case ' ':
                    map[x][y] = new BackgroundDirt(x, y);
                    break;

                default:
                    //erreur
                    break;
            }
            x++;
        }

    }



    /**
     * The init method
     *
     * It initializes the map
     */
    private void init()
    {
        GameProperties properties = GameProperties.getInstance();
        tailleMapX = properties.getTailleMapX();
        tailleMapY = properties.getTailleMapY();

        map = new Block[tailleMapX][tailleMapY];

    }

    /**
     * {@inheritDoc}
     *
     * makes a block move without condition
     */
    public void moveBlock(Direction direction, int blockX, int blockY)
    {
        Block blockADeplacer = map[blockX][blockY];
        map[blockX][blockY] = new BackgroundDirt(blockX, blockY);

        switch (direction) {
            case UP:
                if (blockY > 0) {
                    map[blockX][blockY - 1] = blockADeplacer;
                }
                break;
            case LEFT:
                if (blockX > 0) {
                    map[blockX - 1][blockY] = blockADeplacer;
                }
                break;
            case DOWN:
                if (blockY < tailleMapY) {
                    map[blockX][blockY + 1] = blockADeplacer;
                }
                break;
            case RIGHT:
                if (blockX < tailleMapX) {
                    map[blockX + 1][blockY] = blockADeplacer;
                }
                break;
        }
    }


    //retourne le block a la position donnée
    /** {@inheritDoc} */
    public Block getBlock(int x, int y)
    {
        return map[x][y];
    }

    /** {@inheritDoc} */
    public void print(Graphics g)
    {

        Block player = null;
        Block blockToPrint;
        for (int y = 0; y < tailleMapY; y++)
        {
            for (int x = 0; x < tailleMapX; x++)
            {
                blockToPrint = map[x][y];
                if (blockToPrint instanceof Player)
                {
                    player = blockToPrint;
                }
                else if (blockToPrint != null) {
                    blockToPrint.print(g);
                }
            }
        }
        if (player != null) {
            player.print(g);
        }
    }


    /**
     * <p>getObservable.</p>
     *
     * @return a {@link java.util.Observable} object.
     */
    public Observable getObservable() {
        return this;
    }
}
