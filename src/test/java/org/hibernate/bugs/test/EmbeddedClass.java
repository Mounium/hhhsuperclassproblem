package org.hibernate.bugs.test;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import java.util.Date;

@Embeddable
public class EmbeddedClass {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @PrePersist
    public void persist() {
        date = new Date();
    }
}
