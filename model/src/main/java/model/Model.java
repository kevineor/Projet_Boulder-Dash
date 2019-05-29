package model;

import java.awt.*;
import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.Level;
import entity.Blocks.Stone;

/**
 * The Class Model.
 *
 * @author Valentin
 */
public final class Model extends Observable implements IModel {

	/** The level */
	private Level level;

	private Stone test;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		loadLevel(4);
		//this.test = new Stone(0, 0);
	}

	/**
	 * <p>update.</p>
	 */
	public void update()
	{
		level.update();
		this.setChanged();
		this.notifyObservers();
	}
	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public Level getLevel() {
		return this.level;
	}

	/**
     * Sets the level
     *
     * @param level
     *            the new level
     */
	private void setLevel(final Level level) {
		this.level = level;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * {@inheritDoc}
	 *
	 * Load the level
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadLevel(final int niv) {
		try {
			final DAOLevel daoLevel = new DAOLevel(DBConnection.getInstance().getConnection());
			this.setLevel(daoLevel.find(niv));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/** {@inheritDoc} */
	public void print(Graphics g)
	{
		level.print(g);
		//test.print(g);
	}

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}
