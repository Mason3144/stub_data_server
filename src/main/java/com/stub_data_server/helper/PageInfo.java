package com.stub_data_server.helper;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PageInfo {
    private int page;
    private int size;
    private int totalElements;
    private int totalPages;
}
