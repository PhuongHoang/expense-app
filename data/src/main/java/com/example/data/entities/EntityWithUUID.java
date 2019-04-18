package com.example.data.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;
import lombok.Getter;
import org.hibernate.annotations.Type;

@Getter
@MappedSuperclass
public class EntityWithUUID {
    @Id @Type(type = "pg-uuid")
    private UUID id;

    public EntityWithUUID() {
        this.id = UUID.randomUUID();
    }
}