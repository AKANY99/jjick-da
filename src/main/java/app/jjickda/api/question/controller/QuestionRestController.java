package app.jjickda.api.question.controller;

import app.jjickda.api.question.dto.response.CertificateListDto;
import app.jjickda.api.question.dto.response.ExamListDto;
import app.jjickda.api.question.dto.response.SubjectListDto;
import app.jjickda.api.question.service.QuestionService;
import app.jjickda.domain.user.dto.request.SignUpDto;
import app.jjickda.global.config.model.ApiResponse;
import app.jjickda.global.utils.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "자격증선택 페이지 데이터 처리와 관련된 API.")
@RestController
@RequestMapping("/api")
public class QuestionRestController {

    private final QuestionService questionService;

    public QuestionRestController(QuestionService questionService) { this.questionService = questionService; }

    @ApiOperation("자격증데이터를 가져오는 API")
    @PostMapping("/certificate")
    public ResponseEntity<ApiResponse<List<CertificateListDto>>> questionSelect() {
        List<CertificateListDto> certificateListDto = questionService.questionSelect();
        return ResponseEntity.ok(new ApiResponse<>(certificateListDto));
    }

    @ApiOperation("과목데이터를 가져오는 API")
    @PostMapping("/subject/{subIdx}")
    public ResponseEntity<ApiResponse<List<SubjectListDto>>> subjectSelect(@PathVariable long subIdx) {
        List<SubjectListDto> subjectListDto = questionService.subjectSelect(subIdx);
        return ResponseEntity.ok(new ApiResponse<>(subjectListDto));
    }

    @ApiOperation("회차데이터를 가져오는 API")
    @PostMapping("/exam/{subIdx}")
    public ResponseEntity<ApiResponse<List<ExamListDto>>> examSelect(@PathVariable long subIdx) {
        List<ExamListDto> examListDto = questionService.examSelect(subIdx);
        return ResponseEntity.ok(new ApiResponse<>(examListDto));
    }

}
