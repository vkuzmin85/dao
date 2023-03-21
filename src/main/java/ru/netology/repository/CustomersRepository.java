package ru.netology.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CustomersRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getProductNames(String name) {
        Query query = entityManager.createQuery("select o.productName from Orders o " +
                " join Customers c on c.id = o.customer.id " +
                " where c.name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }
}
