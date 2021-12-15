package by.itacademy.javaenterprise.goralchuk.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j(topic = "/ BASE_DAO")
@Repository
public class BaseDao<T> {
    private final List<T> list = new ArrayList<>();

    public T add(T t) {
        try {
            list.add(t);
            log.debug("The add transaction was successful");
            return t;
        } catch (Exception e) {
            log.error("Error add transaction {}", e.getMessage(), e);
            return null;
        }
    }

    public int remove(int id) {
        try {
            list.remove(id);
            log.debug("The remove transaction was successful");
            return id;
        } catch (Exception e) {
            log.error("No such object was found {}", e.getMessage(), e);
            return 0;
        }
    }

    public List<T> findAll() {
        try {
            return list;
        } catch (Exception e) {
            log.error("No objects found {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
