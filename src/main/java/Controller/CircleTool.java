package Controller;

/**
 * The tool to create circles
 **/

import View.DrawingPanel;
import Model.Circle;
import View.ToolVisitor;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class CircleTool
	extends DrawingTool {
	public boolean iAmActive = false;
	public Point myCenter;
	public int myRadius;
        
	public CircleTool(DrawingPanel panel) {
		super(panel);
	}

        @Override
	public void mousePressed(MouseEvent e) {
		if (!iAmActive) {
			// Center
			iAmActive = true;
			myCenter = e.getPoint();
			myRadius = 0;
			myPanel.setCursor(
				Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)
				);
                        System.out.println("Cercle ajouté");
			myPanel.repaint();
		} else {
			// Radius
			iAmActive = false;
			myDrawing.addShape(
				new Circle(myCenter, myRadius)
				);
			myPanel.setCursor(Cursor.getDefaultCursor());
			myPanel.repaint();
                        
		}
	}

        @Override
	public void mouseMoved(MouseEvent e) {
		if (iAmActive) {
			myRadius = (int) (
				myCenter.distance(e.getPoint())
				);
			myPanel.repaint();
		}
	}
        
        @Override
	public void mouseDragged(MouseEvent e) {
            mouseMoved(e);
        }

        @Override
	public void draw(Graphics2D g) {
		if (iAmActive) {
			g.setColor(Color.red);
			g.drawOval(
				myCenter.x - myRadius,
				myCenter.y - myRadius,
				myRadius * 2,
				myRadius * 2
				);
		}
	}

         public void accept(ToolVisitor v, Graphics2D g) {
            v.visit(this, g);
        }
    
}