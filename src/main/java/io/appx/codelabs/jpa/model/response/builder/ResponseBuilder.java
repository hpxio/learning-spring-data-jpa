package io.appx.codelabs.jpa.model.response.builder;

public interface ResponseBuilder<REQ, RES> {
    RES build(REQ request);
}
