package am.soccer.service;

import org.springframework.http.HttpStatus;

public interface RestClientService {

    String get(String uri);

    String post(String uri, String json);

    void put(String uri, String json);

    void delete(String uri);

    HttpStatus getStatus();

    void setStatus(HttpStatus status);
    
}
