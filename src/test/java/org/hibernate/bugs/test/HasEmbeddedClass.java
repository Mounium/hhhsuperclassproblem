package org.hibernate.bugs.test;

public interface HasEmbeddedClass {
    EmbeddedClass getEmbeddedClass();

    void setEmbeddedClass(EmbeddedClass embeddedClass);
}
