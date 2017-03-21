package com.bindstone.graphbank.utils.rest;

import com.bindstone.graphbank.domain.AbstractNode;
import org.springframework.http.HttpHeaders;

import java.util.List;

public class Header {
    private Header() {
    }

    public static final HttpHeaders defaultHeader() {
        return new HttpHeaders();
    }

    public static final HttpHeaders defaultList(List list) {
        HttpHeaders responseHeaders = defaultHeader();
        responseHeaders.add("size", String.valueOf(list.size()));
        return responseHeaders;
    }

    public static final HttpHeaders defaultNode(AbstractNode node) {
        HttpHeaders responseHeaders = defaultHeader();
        responseHeaders.add("id", node.getId());
        return responseHeaders;
    }

}
