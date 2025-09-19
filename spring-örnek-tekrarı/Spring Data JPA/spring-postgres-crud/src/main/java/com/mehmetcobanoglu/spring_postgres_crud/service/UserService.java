package com.mehmetcobanoglu.spring_postgres_crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmetcobanoglu.spring_postgres_crud.model.User;
import com.mehmetcobanoglu.spring_postgres_crud.repository.UserRepository;

@Service // Bu anotasyon Spring’e “burası iş mantığının (business logic) yazıldığı servis
         // katmanı” demektir.
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        /*
         * Bu, constructor injection denir.
         * Spring otomatik olarak UserRepository bean’ini bulur ve bu sınıfa enjekte
         * eder.
         * Böylece userRepository değişkenini kullanarak veritabanı işlemleri
         * yapabilirsin.
         */
    }

    // Tüm kullanıcıları getir
    public List<User> getAllUsers() {
        return userRepository.findAll();
        /*
         * userRepository.findAll() → veritabanındaki User tablosundaki tüm kayıtları
         * listeler.
         * Dönen değer List<User> tipinde olur.
         * Yani tüm kullanıcıları JSON olarak döndürebileceğin veya başka işlerde
         * kullanabileceğin şekilde getirir.
         */
    }

    // Yeni kullanıcı ekle veya güncelle
    public User saveUser(User user) {
        return userRepository.save(user);
        /*
         * userRepository.save(user) JPA’nın hazır metodudur.Eğer id boşsa → yeni kayıt
         * ekler.
         * Eğer id dolu ve veritabanında varsa → ilgili kaydı günceller.Yani hem insert
         * hem de update işlevi görür.
         */

    }

    // Id'ye göre kullanıcı sil
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        /*
         * userRepository.deleteById(id) → JPA’nın hazır metodudur.
         * Veritabanındaki id’si verilen kullanıcıyı siler.
         * Eğer o id yoksa, EmptyResultDataAccessException fırlatır.
         */
    }
}
