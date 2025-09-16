package com.likelion.seminar.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.likelion.seminar.Exception.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/exception")
public class ExceptionController {

    @GetMapping
    public void getRuntimeException() {
        throw new RuntimeException("getRuntimeException 메서드 호출");
    }

    @GetMapping("/custom")
    public void customException() throws CustomException {
        throw new CustomException(INTERNAL_SERVER_ERROR,"GetcustomException 메서드 호출");
    }


}
