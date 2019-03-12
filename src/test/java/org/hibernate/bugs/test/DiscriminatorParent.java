package org.hibernate.bugs.test;

import javax.persistence.*;

@Entity
@DiscriminatorColumn
public class DiscriminatorParent implements HasEmbeddedClass {
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
