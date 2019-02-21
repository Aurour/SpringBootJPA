package com.spring.jpa.springjpa.respository;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BaseRepository<T> {
    T findAllById(@Param("id") String var1);

    List<T> findAllByStatus (@Param("status") String var1);

    T findAllByIdAndStatus(@Param("id") String var1, @Param("status") String var2);

}
