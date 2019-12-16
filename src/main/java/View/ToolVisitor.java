/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CircleTool;
import Controller.LineTool;
import Controller.SelectionTool;
import java.awt.Graphics2D;

/**
 *
 * @author raguiri
 */
public interface ToolVisitor {
    public void visit(LineTool lt, Graphics2D g);
    
    public void visit(CircleTool ct, Graphics2D g);
    
    public void visit(SelectionTool st, Graphics2D g);
    
    
}
