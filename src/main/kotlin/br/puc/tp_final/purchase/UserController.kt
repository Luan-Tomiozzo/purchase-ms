package br.puc.tp_final.purchase

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse

@RestController
@RequestMapping("/purchase-ms/rest/user")
class UserController(val userService: UserService) {

    @PostMapping("register")
    @ApiOperation(value = "Cria usuário")
    fun buy(): Int {
        return userService.register()
    }
}