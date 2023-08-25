package com.hyperbank.architecture.base.data.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@MappedSuperclass
public abstract class TypeEntity extends CategorizationEntity {

}
