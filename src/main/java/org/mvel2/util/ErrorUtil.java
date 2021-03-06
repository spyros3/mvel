package org.mvel2.util;

import org.mvel2.CompileException;
import org.mvel2.ErrorDetail;

/**
 * @author Mike Brock .
 */
public class ErrorUtil {
    public static CompileException rewriteIfNeeded(CompileException caught, char[] outer, int outerCursor) {
        if (outer != caught.getExpr()) {
            String innerExpr = new String(caught.getExpr()).substring(caught.getCursor());
            caught.setExpr(outer);

            int newCursor = outerCursor;
            newCursor += new String(outer).substring(outerCursor).indexOf(innerExpr);

            caught.setCursor(newCursor);
        }
        return caught;
    }

    public static ErrorDetail rewriteIfNeeded(ErrorDetail detail, char[] outer, int outerCursor) {
        if (outer != detail.getExpr()) {
            String innerExpr = new String(detail.getExpr()).substring(detail.getCursor());
            detail.setExpr(outer);

            int newCursor = outerCursor;
            newCursor += new String(outer).substring(outerCursor).indexOf(innerExpr);

            detail.setCursor(newCursor);
        }
        return detail;
    }
}
