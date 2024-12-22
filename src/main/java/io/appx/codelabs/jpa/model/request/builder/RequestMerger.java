package io.appx.codelabs.jpa.model.request.builder;

public interface RequestMerger <REQ1, REQ2, RES> {
    RES merge (REQ1 req1, REQ2 req2);
}
