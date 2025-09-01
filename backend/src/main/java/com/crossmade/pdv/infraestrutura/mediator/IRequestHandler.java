package com.crossmade.pdv.infraestrutura.mediator;

public interface IRequestHandler<TRequest, TResponse> {
     <TResponse extends IResponse> TResponse handle(IRequest<TResponse> query);
}
