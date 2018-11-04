package com.syuka.model;

import javax.xml.crypto.Data;

@lombok.Data
public class User {

    String username;
    String email;
    String password;
    Data create_time;

}
