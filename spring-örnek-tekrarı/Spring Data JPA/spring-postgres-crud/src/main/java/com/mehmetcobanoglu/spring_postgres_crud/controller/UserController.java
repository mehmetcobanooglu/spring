package com.mehmetcobanoglu.spring_postgres_crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetcobanoglu.spring_postgres_crud.model.User;
import com.mehmetcobanoglu.spring_postgres_crud.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
        /*
         * UserController sınıfı çalıştığında Spring, UserService sınıfının bir bean
         * oluşturur.
         * Constructor parametresine otomatik olarak o UserService nesnesini enjekte
         * eder.
         * Sen de this.userService = userService; diyerek, controller içinde servisi
         * kullanabilir hale getiriyorsun.
         */
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
        /*
         * @GetMapping → Bu metodun HTTP GET isteğiyle çalışacağını belirtir.
         * /users endpoint’ine GET isteği gönderildiğinde bu metod devreye girer.
         * İçeride userService.getAllUsers() çağrılır → bu da UserRepository.findAll()
         * çalıştırır.
         * Sonuç olarak veritabanındaki tüm kullanıcıları JSON formatında döner.
         */
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
        /*
         * @PostMapping → Bu metodun HTTP POST isteğiyle çalışacağını belirtir.
         * 
         * @RequestBody User user → Gelen JSON verisini otomatik olarak User nesnesine
         * dönüştürür.
         * userService.saveUser(user) → Bu nesneyi veritabanına kaydeder.
         */
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        /*
         * @DeleteMapping("/{id}")
         * /users/5 gibi bir HTTP DELETE isteği geldiğinde bu metod çalışır.
         * Yani URL’deki {id} kısmını alır.
         * 
         * @PathVariable Long id
         * URL’deki {id} değerini alır ve id parametresine atar.
         * Örneğin /users/3 isteğinde → id = 3 olur.
         * userService.deleteUser(id)
         * Servis katmanındaki deleteUser metodunu çağırır.
         * Bu metod veritabanında o id’ye sahip kullanıcıyı siler.
         */
    }
}
