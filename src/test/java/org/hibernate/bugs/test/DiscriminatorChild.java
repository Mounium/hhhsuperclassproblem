package org.hibernate.bugs.test;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class DiscriminatorChild extends DiscriminatorParent {
}
