package io.appx.codelabs.jpa.model.request.builder;

public interface RequestBuilder<REQ, RES> {
    RES build(REQ request);
}