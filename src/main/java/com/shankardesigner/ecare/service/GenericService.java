package com.shankardesigner.ecare.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GenericService<T> {

    public T saveInfo(T t);

    public T updateInfo(T t);

    public boolean deleteInfo(UUID id);

    public List<T> getAllInfo();

    public Optional<T> getInfoById(UUID id);
}
