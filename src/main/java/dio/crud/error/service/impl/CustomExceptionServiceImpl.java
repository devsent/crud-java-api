package dio.crud.error.service.impl;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Date;

import dio.crud.error.model.CustomException;
import dio.crud.error.service.CustomExceptionService;


public class CustomExceptionServiceImpl implements CustomExceptionService {
    @Override
    public CustomException error(Integer status, String error) {
        ServletUriComponentsBuilder uri = ServletUriComponentsBuilder.fromCurrentRequestUri();
        String modifiedUri = uri.host(null).toUriString().replace("http:", "");

        return new CustomException(
                new Date(),
                status,
                error,
                modifiedUri
        );
    }
}
