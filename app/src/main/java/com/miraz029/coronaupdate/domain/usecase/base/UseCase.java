package com.miraz029.coronaupdate.domain.usecase.base;

import io.reactivex.Observable;

public abstract class UseCase<T> {

    public abstract Observable<T> buildUseCaseObservable();

}