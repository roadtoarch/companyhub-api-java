package io.github.paulushcgcj.models;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
public class PagedResponse<T> {
    private List<T> data;
    private long total;
    private long pages;
    private boolean first;
    private boolean last;
    private boolean next;
    private boolean previous;
}
