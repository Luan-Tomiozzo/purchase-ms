package br.puc.tp_final.purchase.configuration

import br.puc.tp_final.purchase.exception.BusinessException
import br.puc.tp_final.purchase.exception.StandardError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class DefaultExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): ResponseEntity<StandardError?>? {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                createResponseError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Falha na requisição.", e.message)
        )
    }

    private fun createResponseError(timestamp: Long, status: Int, error: String, message: String?): StandardError? {
        return StandardError(timestamp, status, error, message);
    }
}