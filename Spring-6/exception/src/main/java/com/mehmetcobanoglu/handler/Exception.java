package com.mehmetcobanoglu.handler;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exception<E> {

    private String hostName;

    private String path;

    private Date createTime;

    private E message;
}
