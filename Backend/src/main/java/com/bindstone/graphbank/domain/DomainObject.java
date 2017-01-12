package com.bindstone.graphbank.domain;

import java.util.Date;

/**
 * General Interface for some Generic operations.
 */
public interface DomainObject {

    Long getNodeId();

    void setNodeId(Long nodeId);

    String getId();

    void setId(String id);

    Date getCreated();

    void setCreated(Date timestamp);

    Date getModified();

    void setModified(Date timestamp);
}
