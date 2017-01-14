package com.bindstone.graphbank.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Abstract Node class, containing the common properties for all Nodes.
 */
public abstract class AbstractNode implements Serializable, DomainObject {
    /**
     * NodeId represent the result of id(node), the node ID. Neo4J
     * discurage to use this id.
     */
    private Long nodeId;
    /**
     * UUID String, containing to identify the Node.
     */
    private String id;
    /**
     * Timestamp set on creation.
     */
    private Date created;
    /**
     * Timestamp set on each modification.
     */
    private Date modified;

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public Date getModified() {
        return modified;
    }

    @Override
    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public Long getNodeId() {
        return nodeId;
    }

    @Override
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

}
