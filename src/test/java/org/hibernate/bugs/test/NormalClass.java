package org.hibernate.bugs.test;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NormalClass implements HasEmbeddedClass {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private EmbeddedClass embeddedClass;

    public EmbeddedClass getEmbeddedClass() {
        return embeddedClass;
    }

    public void setEmbeddedClass(EmbeddedClass embeddedClass) {
        this.embeddedClass = embeddedClass;
    }
}
