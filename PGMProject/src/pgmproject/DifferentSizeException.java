/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmproject;

/**
 * Exception levée lorsque l'on essaie de comparer deux images de tailles différentes.
 * @author tlaurent
 */
public class DifferentSizeException extends Exception {

    /**
     * Creates a new instance of
     * <code>DifferentSizeException</code> without detail message.
     */
    public DifferentSizeException() {
    }

    /**
     * Constructs an instance of
     * <code>DifferentSizeException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public DifferentSizeException(String msg) {
        super(msg);
    }
}
