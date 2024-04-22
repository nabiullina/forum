package com.nabiullina.forum.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @NotBlank(message = "Article name cannot be empty")
    private String name;

    @Nullable
    private String description;

    @OneToMany(fetch=FetchType.LAZY)
    private List<Post> posts;

    private Instant createdOn;

    @ManyToOne(fetch=FetchType.LAZY)
    private User user;

}
