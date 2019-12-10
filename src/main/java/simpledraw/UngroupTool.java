package simpledraw;

import Model.Shape;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * The tool to select, move and delete Shapes in the Drawing
 * @author raguiri
 * @version 1.0
 */

public class UngroupTool 
	extends DrawingTool {
	private Shape mySelectedShape = null;
	private Point myLastPoint;

	public UngroupTool(DrawingPanel panel) {
		super(panel);
	}
        
        void draw(Graphics2D g) {
	}
        
}        
