package com.popa.books.util;

import org.apache.commons.lang.exception.ExceptionUtils;

public class ExceptionUtil {

    private ExceptionUtil() {
    }

    public static String getExceptionCause(final Throwable exc) {
        StringBuilder cause = new StringBuilder();
        if (exc != null) {
            String rootCause = ExceptionUtils.getRootCauseMessage(exc);
            String[] rootStacktrace = ExceptionUtils.getRootCauseStackTrace(exc);
            for (String aRootStacktrace : rootStacktrace) {
                if ((aRootStacktrace == null)) {
                    continue;
                }
                if (aRootStacktrace.contains(rootCause)) {
                    cause.append(aRootStacktrace);
                }
            }
        }
        return cause.toString();
    }

    public static String[] getExceptionCauseAndStackTrace(final Throwable exc) {
        StringBuilder cause = new StringBuilder();
        StringBuilder stack = new StringBuilder();
        if (exc != null) {
            String rootCause = ExceptionUtils.getRootCauseMessage(exc);
            String[] rootStacktrace = ExceptionUtils.getRootCauseStackTrace(exc);
            for (String aRootStacktrace : rootStacktrace) {
                if ((aRootStacktrace == null)) {
                    continue;
                } else if (aRootStacktrace.contains(rootCause)) {
                    cause.append(aRootStacktrace);
                    continue;
                }
                stack.append("\t").append(aRootStacktrace).append("\n");
            }
            if (cause.length() == 0) {
                final String tmp = stack.toString();
                if (tmp.indexOf('\n') != -1) {
                    cause.append(tmp.substring(0, tmp.indexOf('\n')).trim());
                }
            }
        }
        if (stack.length() == 0) {
            stack.append("\t").append("Nu se cunosc detaliile erorii...");
        }
        return new String[]{cause.toString(), stack.toString()};
    }

}
