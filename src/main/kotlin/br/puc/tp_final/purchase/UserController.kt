package br.puc.tp_final.purchase

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/purchase-ms/rest/user")
class UserController(val userService: UserService) {

    @PostMapping("register")
    fun buy(): Int {
        return userService.register()
    }
}