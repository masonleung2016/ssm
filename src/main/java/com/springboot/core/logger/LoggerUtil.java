package com.springboot.core.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO(描述类的职责) 自定义日志类 ;后续需要扩展自己添加
 *
 * @Author: LCF
 * @Date: 2020/1/2 17:36
 * @Package: com.springboot.core.logger
 */
public class LoggerUtil {

    /**
     * FQCN
     */
    private static final String FQCN = LoggerUtil.class.getName();
    /**
     * NOT_AVAIL
     */
    private static final String NOT_AVAIL = "?";

    /**
     * 获取最原始被调用的堆栈信息
     *
     * <p>
     * TODO(方法详细描述说明、方法参数的具体涵义)
     * </p>
     *
     * @param stackTrace
     * @return
     *
     */
    private static StackTraceElement getStackTraceElement(
            final StackTraceElement[] stackTrace) {
        boolean next = false;
        for (final StackTraceElement element : stackTrace) {
            final String className = element.getClassName();
            if (next && !FQCN.equals(className)) {
                return element;
            }
            if (FQCN.equals(className)) {
                next = true;
            } else if (NOT_AVAIL.equals(className)) {
                break;
            }
        }
        return null;
    }

    /**
     *
     *
     * <p>
     * TODO(方法详细描述说明、方法参数的具体涵义)info
     * </p>
     *
     * @param message
     *
     */
    public static void info(final String message) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller) {
            return;
        }
        Logger log = LoggerFactory
                .getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.info(message);
    }

    /**
     *
     *
     * <p>
     * TODO(方法详细描述说明、方法参数的具体涵义)info
     * </p>
     *
     * @param message
     * @param t
     *
     */
    public static void info(final String message, Throwable t) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller) {
            return;
        }
        Logger log = LoggerFactory
                .getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.info(message, t);
    }

    /**
     *
     *
     * <p>
     * TODO(方法详细描述说明、方法参数的具体涵义)debug
     * </p>
     *
     * @param message
     *
     */
    public static void debug(final String message) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller) {
            return;
        }
        Logger log = LoggerFactory
                .getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.debug(message);
    }

    /**
     *
     *
     * <p>
     * TODO(方法详细描述说明、方法参数的具体涵义)debug
     * </p>
     *
     * @param message
     * @param t
     *
     */
    public static void debug(final String message, Throwable t) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller) {
            return;
        }
        Logger log = LoggerFactory
                .getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.debug(message, t);
    }

    /**
     * <p>
     * TODO(方法详细描述说明、方法参数的具体涵义)error
     * </p>
     *
     * @param message
     *
     */
    public static void error(final String message) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller) {
            return;
        }
        Logger log = LoggerFactory
                .getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.error(message);
    }

    /**
     * <p>
     * TODO(方法详细描述说明、方法参数的具体涵义)error
     * </p>
     *
     * @param message
     * @param t
     *
     */
    public static void error(final String message, Throwable t) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller) {
            return;
        }
        Logger log = LoggerFactory
                .getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.error(message, t);
    }

    /**
     *
     *
     * <p>
     * TODO(方法详细描述说明、方法参数的具体涵义)warn
     * </p>
     *
     * @param message
     *
     */
    public static void warn(final String message) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller) {
            return;
        }
        Logger log = LoggerFactory
                .getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.warn(message);
    }
}
