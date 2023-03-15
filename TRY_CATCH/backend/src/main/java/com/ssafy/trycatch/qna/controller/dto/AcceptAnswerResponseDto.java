package com.ssafy.trycatch.qna.controller.dto;

import com.ssafy.trycatch.common.domain.QuestionCategory;
import com.ssafy.trycatch.qna.domain.Question;
import com.ssafy.trycatch.user.controller.dto.SimpleUserDto;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

import static com.ssafy.trycatch.common.infra.config.ConstValues.TZ_SEOUL;

@Data
public class AcceptAnswerResponseDto implements Serializable {
    public static AcceptAnswerResponseDto from(
            Question question,
            List<FindAnswerResponseDto> answerDtoList,
            SimpleUserDto author,
            Boolean isLiked,
            Boolean isBookmarked
    ) {
        final Long timestamp = question.getCreatedAt()
                                       .atZone(TZ_SEOUL)
                                       .toInstant()
                                       .toEpochMilli();

        return AcceptAnswerResponseDto.builder()
                .questionId(question.getId())
                .author(author)
                .category(question.getCategoryName())
                .title(question.getTitle())
                .content(question.getContent())
                .errorCode(question.getErrorCode())
                .tags(List.of(question.getTags()
                                      .split(",")))
                .likeCount(question.getLikes())
                .answerCount(answerDtoList.size())
                .viewCount(question.getViewCount())
                .timestamp(timestamp)
                .updatedAt(question.getUpdatedAt()
                                   .toEpochMilli())
                .isLiked(isLiked)
                .isSolved(question.getChosen())
                .isBookmarked(isBookmarked)
                .answers(answerDtoList)
                .build();
    }

    private final Long questionId;
    @Size(max = 50)
    private final SimpleUserDto author;
    @Size(max = 30)
    private final QuestionCategory category;
    @Size(max = 50)
    private final String title;
    private final String content;
    private final String errorCode;
    private final List<String> tags;
    private final Integer likeCount;
    private final Integer answerCount;
    private final Integer viewCount;
    private final Long timestamp;
    private final Long updatedAt;
    private final Boolean isLiked;
    private final Boolean isSolved;
    private final Boolean isBookmarked;
    private final List<FindAnswerResponseDto> answers;

    @Builder
    public AcceptAnswerResponseDto(
            Long questionId,
            SimpleUserDto author,
            QuestionCategory category,
            String title,
            String content,
            String errorCode,
            List<String> tags,
            Integer likeCount,
            Integer answerCount,
            Integer viewCount,
            Long timestamp,
            Long updatedAt,
            Boolean isLiked,
            Boolean isSolved,
            Boolean isBookmarked,
            List<FindAnswerResponseDto> answers
    ) {
        this.questionId = questionId;
        this.author = author;
        this.category = category;
        this.title = title;
        this.content = content;
        this.errorCode = errorCode;
        this.tags = tags;
        this.likeCount = likeCount;
        this.answerCount = answerCount;
        this.viewCount = viewCount;
        this.timestamp = timestamp;
        this.updatedAt = updatedAt;
        this.isLiked = isLiked;
        this.isSolved = isSolved;
        this.isBookmarked = isBookmarked;
        this.answers = answers;
    }
}