package com.mehmetcobanoglu.spring_postgres_crud.repository;

import com.mehmetcobanoglu.spring_postgres_crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // springe burası veritabanı işlemlerini yapan bir repository katmanı der
public interface UserRepository extends JpaRepository<User, Long> {
    /*
     * JpaRepository JPA’nın hazır bir CRUD (Create, Read, Update, Delete)
     * operasyonlarını sağlayan interface’idir.
     * User → bu repository’nin hangi entity üzerinde çalışacağını söylüyorsun (yani
     * User sınıfı). Long → User entity’sindeki id alanının tipi.
     */
}
