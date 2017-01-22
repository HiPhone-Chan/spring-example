package com.chf.spring.common.utils;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.util.Assert;

public abstract class AopUtil {

    @SuppressWarnings("unchecked")
    public static <T> T getTargetObject(Object candidate) {
        Assert.notNull(candidate, "candidate must not be null");
        try {
            if (AopUtils.isAopProxy(candidate)
                    && (candidate instanceof Advised)) {
                return ((T) ((Advised) candidate).getTargetSource()
                        .getTarget());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Failed to unwrap proxied object.",
                    e);
        }
        return (T) candidate;
    }
}
