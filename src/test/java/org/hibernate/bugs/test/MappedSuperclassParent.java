package org.hibernate.bugs.test;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class MappedSuperclassParent implements HasEmbeddedClass {
    @Embedded
    private EmbeddedClass embeddedClass;

    public EmbeddedClass getEmbeddedClass() {
        return embeddedClass;
    }

    public void setEmbeddedClass(EmbeddedClass embeddedClass) {
        this.embeddedClass = embeddedClass;
    }
}
