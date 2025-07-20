package com.likelion.seminar.student.controller;
import com.likelion.seminar.student.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping ("student")

public class StudentController {
    private final List<StudentDTO> studentDTOList;


    // 신규 학생 
    @PostMapping()
    public void createList(@RequestBody StudentDTO studentDTO) {
        System.out.println(studentDTO.toString()); //콘솔에 추가된 학생 정보 출력
        this.studentDTOList.add(studentDTO);
    }

    // 학생 조회
    @GetMapping()
    public List<StudentDTO> readListAll() {
        System.out.println("리스트 전체 조회");
        return this.studentDTOList;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> readList(@PathVariable("id") int id) {
        System.out.println("학번으로 리스트 단일 조회");
        for (StudentDTO student : studentDTOList) {
            if (student.getStudentId() == id) {
                return ResponseEntity.ok(student); // 성공 응답
            }
        }

        // 실패 응답 (학생 없음)
        Map<String, Object> error = new HashMap<>();
        error.put("status", 404);
        error.put("message", "학생을 찾을 수 없습니다.");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    // 정보 수정
    @PutMapping("{id}")
    public ResponseEntity<?> updateList(@PathVariable("id") int id, @RequestBody StudentDTO studentDTO) {
        for (int i = 0; i < studentDTOList.size(); i++) {
            StudentDTO target = studentDTOList.get(i);
            if (target.getStudentId() == id) {

                if (studentDTO.getStudentId() != null) {
                    target.setStudentId(studentDTO.getStudentId());
                }
                if (studentDTO.getName() != null) {
                    target.setName(studentDTO.getName());
                }
                if (studentDTO.getDateOfBirth() != null) { // 기본값 체크
                    target.setDateOfBirth(studentDTO.getDateOfBirth());
                }

                // 리스트에서 갱신
                studentDTOList.set(i, target);
                return ResponseEntity.ok(target); // 성공 응답
            }
        }

        // 실패 응답 (학생 없음)
        Map<String, Object> error = new HashMap<>();
        error.put("status", 404);
        error.put("message", "학생을 찾을 수 없습니다.");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // 학생 삭제
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteList(@PathVariable("id") int id) {
        for (int i = 0; i < studentDTOList.size(); i++) {
            if (studentDTOList.get(i).getStudentId() == id) {
                studentDTOList.remove(i); // 인덱스로 안전하게 삭제
                return ResponseEntity.ok().build();  // 성공 응답
            }
        }

        // 실패 응답 (학생 없음)
        Map<String, Object> error = new HashMap<>();
        error.put("status", 404);
        error.put("message", "학생을 찾을 수 없습니다.");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
