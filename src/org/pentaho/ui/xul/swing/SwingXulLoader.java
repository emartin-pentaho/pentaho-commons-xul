/**
 * 
 */
package org.pentaho.ui.xul.swing;

import org.dom4j.Document;
import org.dom4j.Element;
import org.pentaho.core.util.CleanXmlHelper;
import org.pentaho.ui.xul.XulElement;
import org.pentaho.ui.xul.XulException;
import org.pentaho.ui.xul.XulLoader;
import org.pentaho.ui.xul.XulParser;
import org.pentaho.ui.xul.XulRunner;
import org.pentaho.ui.xul.XulWindowContainer;
import org.pentaho.ui.xul.swing.tags.SwingButtonHandler;
import org.pentaho.ui.xul.swing.tags.SwingCaptionHandler;
import org.pentaho.ui.xul.swing.tags.SwingCheckboxHandler;
import org.pentaho.ui.xul.swing.tags.SwingGroupboxHandler;
import org.pentaho.ui.xul.swing.tags.SwingHboxHandler;
import org.pentaho.ui.xul.swing.tags.SwingLabelHandler;
import org.pentaho.ui.xul.swing.tags.SwingScriptHandler;
import org.pentaho.ui.xul.swing.tags.SwingSpacerHandler;
import org.pentaho.ui.xul.swing.tags.SwingTextboxHandler;
import org.pentaho.ui.xul.swing.tags.SwingVboxHandler;
import org.pentaho.ui.xul.swing.tags.SwingWindowHandler;
import org.pentaho.ui.xul.swing.tags.SwingWindow;

/**
 * @author OEM
 *
 */
public class SwingXulLoader implements XulLoader {

  /* (non-Javadoc)
   * @see org.pentaho.ui.xul.XulLoader#loadXul(org.w3c.dom.Document)
   */
  public XulRunner loadXul(Document xulDocument) throws IllegalArgumentException, XulException{
    
    XulWindowContainer container = new XulWindowContainer();
    XulParser parser = new XulParser(container);

    //attach Renderers
    parser.registerHandler("WINDOW", new SwingWindowHandler());
    parser.registerHandler("BUTTON", new SwingButtonHandler());
    parser.registerHandler("VBOX", new SwingVboxHandler());
    parser.registerHandler("HBOX", new SwingHboxHandler());
    parser.registerHandler("LABEL", new SwingLabelHandler());
    parser.registerHandler("TEXTBOX", new SwingTextboxHandler());
    parser.registerHandler("SCRIPT", new SwingScriptHandler());
    parser.registerHandler("SPACER", new SwingSpacerHandler());
    parser.registerHandler("CHECKBOX", new SwingCheckboxHandler());
    parser.registerHandler("GROUPBOX", new SwingGroupboxHandler());
    parser.registerHandler("CAPTION", new SwingCaptionHandler());
    
    parser.parseDocument(xulDocument.getRootElement());
    
    XulRunner runner = new SwingXulRunner();
    runner.addContainer(container);
    
    return runner;
  }
  

}
