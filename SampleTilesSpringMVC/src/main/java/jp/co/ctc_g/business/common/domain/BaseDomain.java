/*
 * Created on 2006/03/31
 * Copyright (c) 2006 ITOCHU Techno-Solutions Corporation. All Rights Reserved.
 */

package jp.co.ctc_g.business.common.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * <p>
 * ドメインオブジェクトのベースクラス.
 * </p>
 * @author ITOCHU Techno-Solutions Corporation
 */
public abstract class BaseDomain implements Serializable {

    /**
     * {@inheritDoc}
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {

        return EqualsBuilder.reflectionEquals(this, other);
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {

        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    public String toString() {

        return ToStringBuilder.reflectionToString(this);
    }

}
