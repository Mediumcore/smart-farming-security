package com.sdpm.sf.security.common.exception;

/**
 * 业务异常
 *
 * @author rukey
 */
public class SmartFarmingSecurityException extends RuntimeException {
    private static final long serialVersionUID = 102410141126L;

    public SmartFarmingSecurityException(String message) {
        this(message, null);
    }

    public SmartFarmingSecurityException(Throwable cause) {
        this(null, cause);
    }

    public SmartFarmingSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    protected SmartFarmingSecurityException(String message, Throwable cause, boolean enableSuppression,
                                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
