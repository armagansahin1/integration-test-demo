package com.loki.integrationtestdemo.controller.abstracts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

public class AbstractController {


    public ResponseEntity<?> created(){
        return created(null);
    }

    public ResponseEntity<?> created(Object content){
        return ResponseEntity.status(HttpStatus.CREATED).body(content);
    }

    public ResponseEntity<?> ok(){
        return ok(null);
    }

    public ResponseEntity<?> ok(Object content){
        return ResponseEntity.ok(content);
    }

    public ResponseEntity<?> badRequest(){
        return badRequest(null);
    }

    public ResponseEntity<?> badRequest(@Nullable Object content){
        return ResponseEntity.badRequest().body(content);
    }

}
