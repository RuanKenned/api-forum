package br.com.alura.apiforum.exception

import br.com.alura.apiforum.dto.ErrorView
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptonHandler {
    
    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(excption: NotFoundException, request: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = excption.message,
            path = request.servletPath
        )
    }
    
    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(excption: Exception, request: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = excption.message,
            path = request.servletPath
        )
    }
    
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleVAlidationError(excption: MethodArgumentNotValidException, request: HttpServletRequest): ErrorView {
        val errorMessage = HashMap<String, String?>();
        excption.bindingResult.fieldErrors.forEach {
            e -> errorMessage.put(e.field, e.defaultMessage)
        }
        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errorMessage.toString(),
            path = request.servletPath
        )
    }
}