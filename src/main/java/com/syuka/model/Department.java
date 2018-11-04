package com.syuka.model;

import lombok.Data;

@Data
public class Department {
    int id;
    String name;
    int parentId;
    String depPath;
    boolean enabled;
    boolean isParent;
}
