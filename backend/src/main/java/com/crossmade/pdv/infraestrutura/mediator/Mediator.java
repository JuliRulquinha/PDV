package com.crossmade.pdv.infraestrutura.mediator;

public interface Mediator {
    <R extends IResponse> R send(IRequest<R> query);
}
