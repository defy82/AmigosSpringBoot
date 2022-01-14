package com.example.amigosspringboot.model;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import org.springframework.lang.NonNull;

import java.util.UUID;

public class Person {

    private final UUID id;

    @NotEmpty
    @NonNull
    private final String named;

    public Person(UUID id, @NotNull String named) {
        this.id = id;
        this.named = named;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return named;
    }
}
