package Model;

/**
 * Drawing, a collection of Shapes
 * @author Rémi Bastide
 * @version 1.0
 * @see simpledraw.Shape
 */

import Model.Shape;
import View.DrawingView;
import java.util.*;

import java.awt.Graphics2D;
import java.awt.Point;

public class Drawing {
	/**
	 * A drawing is a collection of shapes
	 */
	public List<Shape> myShapes = new LinkedList<Shape>();
        private Set<DrawingView> myViews = new java.util.HashSet<DrawingView> ();

	public Drawing() {
	}

	/**
	 * Displays the drawing
	 * @param g     The Graphics to display on
	 **/
	public void draw(Graphics2D g) {
		for(Shape s : myShapes)
			s.draw(g);
	}

	/**
	 * Add a shape to the Drawing
	 * @param s     The Shape to add
	 **/
	public void addShape(Shape s) {
		myShapes.add(s);
	}

	/**
	 * Delete a shape from the Drawing
	 * @param s     The Shape to delete
	 **/
	public void deleteShape(Shape s) {
		myShapes.remove(s);
	}

	/**
	 * Determines whether the given Point lies whithin a Shape
	 * @param p     The Point to test
	 * @return      A Shape selected by this Point or null if no Shape is there
	 **/
	public Shape pickShapeAt(Point p) {
		Shape result = null;
		for (Shape s : myShapes)
			if (s.isPickedBy(p)) {
				result = s;
				break;
			}
		return result;
	}

	/**
	 * Ensures that no Shape is currently selected
	 */
	public void clearSelection() {
		for (Shape s : myShapes)
			s.setSelected(false);
	}
        public List<Shape> getShapes(){
            return myShapes;
        }
        
        public void addView(DrawingView l){
            myViews.add(l);
            l.notify(this);
        }
        
        public void removeView(DrawingView l){
            myViews.remove(l);
        }
        
        protected void notifyViews() {
		if (null != myViews) 
			for (DrawingView view : myViews) 
				view.notify(this);
	}
}
