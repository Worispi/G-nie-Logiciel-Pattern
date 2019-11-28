/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * The tool to select, move and delete Shapes in the Drawing
 * @author Rémi Bastide
 * @version 1.0
 */

public class GroupTool 
	extends DrawingTool {
	private Shape mySelectedShape = null;
	private Point myLastPoint;

	public GroupTool(DrawingPanel panel) {
		super(panel);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_DELETE) {
			if (mySelectedShape != null) {
				myDrawing.deleteShape(mySelectedShape);
				myPanel.repaint();
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		Shape pickedShape = myDrawing.pickShapeAt(e.getPoint());        //problème
		myLastPoint = e.getPoint();                                     //problème
		mySelectedShape = pickedShape;                                  //problème : ne prend que la dernière forme en compte
		if (mySelectedShape != null) {
			mySelectedShape.setSelected(true);
			myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		}
		myPanel.repaint();
	}

	public void mouseReleased(MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseMoved(MouseEvent e) {
		Shape pickedShape = myPanel.myDrawing.pickShapeAt(e.getPoint());
		if (pickedShape != null) {
			myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		} else {
			myPanel.setCursor(Cursor.getDefaultCursor());
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (mySelectedShape != null) {
			mySelectedShape.translateBy(
				e.getX() - myLastPoint.x,
				e.getY() - myLastPoint.y
				);
			myLastPoint = e.getPoint();
        		myPanel.repaint();
		}
	}

	void draw(Graphics2D g) {
	}

}