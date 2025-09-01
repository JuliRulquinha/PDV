package com.crossmade.pdv.infraestrutura.mediator;

import java.util.Map;

public class SimpleMediator implements Mediator {
    private final Map<Class<?>, IResponse> handlers;

    public SimpleMediator(Map<Class<?>, IResponse> handlers) {
        this.handlers = handlers;
    }

    @Override
    public <R extends IResponse> R send(IRequest<R> request) {
        IRequestHandler handler = handlers.get(request.getClass());
        if (handler == null) throw new IllegalArgumentException("No handler for " + request.getClass());
        try {
            return (R) handler.getClass().getMethod("handle", request.getClass()).invoke(handler, request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
}
