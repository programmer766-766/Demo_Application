package com.demo.application.util;

import com.demo.application.exception.IdNotFoundException;

public interface Util {
     static RuntimeException idNotFound(){
        return new IdNotFoundException("There is no id");
    }
}
