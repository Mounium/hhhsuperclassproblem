package org.hibernate.bugs.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MappedSuperclassChild extends MappedSuperclassParent {
    @Id
    @GeneratedValue
    private Long id;
}
