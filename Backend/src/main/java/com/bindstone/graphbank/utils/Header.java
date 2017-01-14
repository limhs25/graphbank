package com.bindstone.graphbank.utils;

import com.bindstone.graphbank.domain.AbstractNode;
import org.springframework.http.HttpHeaders;

import java.util.List;

public class Header {

    public static final HttpHeaders DEFAULT() {
        return new HttpHeaders();
    }

    public static final HttpHeaders DEFAULT_LIST(List list) {
        HttpHeaders responseHeaders = DEFAULT();
        responseHeaders.add("size", String.valueOf(list.size()));
        return responseHeaders;
    }

    public static final HttpHeaders DEFAULT_NODE(AbstractNode node) {
        HttpHeaders responseHeaders = DEFAULT();
        responseHeaders.add("id", node.getId());
        return responseHeaders;
    }

}
