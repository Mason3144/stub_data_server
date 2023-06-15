package com.stub_data_server.helper;


import com.stub_data_server.question.QuestionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MultiResponseDto {
    private List<QuestionDto.MultiResponse> data;
    private PageInfo pageInfo;
}
