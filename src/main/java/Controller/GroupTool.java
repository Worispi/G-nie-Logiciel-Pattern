/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.DrawingPanel;
import Controller.DrawingTool;
import Model.Shape;
import Model.Shape;
import View.ToolVisitor;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

/**
 * The tool to select, move and delete Shapes in the Drawing
 * @author bberruez
 * @version 1.0
 */

public class GroupTool 
	extends DrawingTool {
	private List<Shape> mySelectedShapes;
	private Point myLastPoint;

	public GroupTool(DrawingPanel panel) {
		super(panel);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_DELETE) {
			if (mySelectedShapes != null) {
                                for (int i =0; i < mySelectedShapes.size(); i++){
				myDrawing.deleteShape(mySelectedShapes.get(i));
				myPanel.repaint();
                                }
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		Shape pickedShape = myDrawing.pickShapeAt(e.getPoint());
                if(pickedShape != null){
                    myLastPoint = e.getPoint();
                    if (pickedShape.isSelected() == false){
                        if (mySelectedShapes==null){
                            mySelectedShapes = new LinkedList<Shape>();
                        }
                        mySelectedShapes.add(pickedShape);
                        myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));  
                    }
                    else {
                        mySelectedShapes.remove(pickedShape);
                        if (mySelectedShapes.size()==0){
                            myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));                        
                        }
                    }
                    pickedShape.setSelected(!pickedShape.isSelected());
                    myPanel.repaint();
                }
	}

	public void mouseReleased(MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseMoved(MouseEvent e) {
		Shape pickedShape = myPanel.getMyDrawing().pickShapeAt(e.getPoint());
		if (pickedShape != null) {
			myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		} else { 
			myPanel.setCursor(Cursor.getDefaultCursor());
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (mySelectedShapes != null) {
                    for (int i =0; i<mySelectedShapes.size() ; i++){
			mySelectedShapes.get(i).translateBy(
				e.getX() - myLastPoint.x,
				e.getY() - myLastPoint.y
				);
                    }
			myLastPoint = e.getPoint();
        		myPanel.repaint();
		}
	}

	public void draw(Graphics2D g) {
	}

    @Override
    public void accept(ToolVisitor v, Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}