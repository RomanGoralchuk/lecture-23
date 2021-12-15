package by.itacademy.javaenterprise.goralchuk.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
public class BaseDao<T> {
    private final List<T> list = new ArrayList<>();

    public void add(T t) {
        try {
            list.add(t);
            log.debug("The transaction was successful");
        } catch (Exception e){
            log.error("Error ADD transaction {}" , e.getMessage(), e);
        }
    }

    public void remove(int id) {
        try {
            list.remove(id);
            log.debug("The transaction was successful");
        } catch (Exception e){
            log.error("No such object was found {}" , e.getMessage(), e);
        }
    }

    public List<T> findAll() {
        try {
            return list;
        } catch (Exception e){
            log.error("No objects found {}" , e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
