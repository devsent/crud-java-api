package dio.crud.error.service;

import dio.crud.error.model.CustomException;

public interface CustomExceptionService {
    CustomException error(Integer status, String error);
}
