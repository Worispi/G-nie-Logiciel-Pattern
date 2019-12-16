package Model;

/**
 * The Shape abstract class, super-class of all Shapes
 * @author Rémi Bastide
 * @version 1.0
 */
import View.ShapeDraw;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;


public abstract class Shape {
	private boolean iAmSelected = false;
	/**
	 * Is this shape selected ?
	 * @return true if selected, false otherwise
	 */
	public boolean isSelected() {
		return iAmSelected;
	}

	/**
	 * Sets the selected status of this shape
	 * @param selected is the shape selected or not ?
	 */
	public void setSelected(boolean selected) {
		iAmSelected = selected;
	}

	/**
	 * Draws this shape in a graphics context
	 * @param g the graphics to draw into
	 */
	abstract public void draw(Graphics2D g);

	/**
	 * Translates this shape
	 * @param dx delta x
	 * @param dy delta y
	 */
	abstract public void translateBy(int dx, int dy);

	/**
	 * Determines if the given point is inside this shape
	 * @param p the point to test
	 * @return true if <code>p</code> inside the shape, false otherwise
	 */
	abstract public boolean isPickedBy(Point p);

    public void accept(ShapeDraw aThis, Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setBackgroundColor(Color BLACK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
