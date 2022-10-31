package br.puc.tp_final.purchase.exception

import org.springframework.context.support.DefaultMessageSourceResolvable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.util.stream.Collectors

@ControllerAdvice
class RestControllerException {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseBody
    fun processUnmergeException(ex: MethodArgumentNotValidException): ResponseEntity<List<String>> {

        val list: List<String> = ex.bindingResult?.allErrors?.stream()
            ?.map(DefaultMessageSourceResolvable::getDefaultMessage)
            ?.collect(Collectors.toList()) as List<String>

        return ResponseEntity(list, HttpStatus.BAD_REQUEST)
    }
}