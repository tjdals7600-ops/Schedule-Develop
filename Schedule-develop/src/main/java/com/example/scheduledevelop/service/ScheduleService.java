package com.example.scheduledevelop.service;


import com.example.scheduledevelop.dto.*;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public class ScheduleService {
    // 속성
    // 스케줄서비스가 스케줄레포지토리 속성을 가짐
    private final ScheduleRepository scheduleRepository;

    // 생성자
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }




    // 일정 생성
    // 1.컨트롤러에서 데이터 받아오기
    @Transactional
    public ScheduleSaveResponse save(ScheduleSaveRequest request) {
        // 2. 받아온 데이터 준비하기
        String newAuthor = request.getAuthor(); // 작성자
        String newTitle = request.getTitle();  // 일정 제목
        String newContent = request.getContent(); // 일정 내용


        // 3.저장할 스케줄 만들기
        Schedule schedule = new Schedule(newAuthor, newTitle, newContent);

        // 4.스케줄을 저장하고 저장된 스케줄 받기
        Schedule savedSchedule = scheduleRepository.save(schedule);
        //스케줄 레포지토리에 만들어준 스케줄을 저장하고 savedSchedule에 담아준다.

        // 5.저장된 데이터 준비
        Long savedScheduleID = savedSchedule.getId();
        String savedScheduleAuthor = savedSchedule.getAuthor();
        String savedScheduleTitle = savedSchedule.getTitle();
        String savedScheduleContent = savedSchedule.getContent();

        // 6. 응답 dto 만들어주기
        ScheduleSaveResponse scheduleSaveResponse = new ScheduleSaveResponse(
                savedScheduleID,
                savedScheduleAuthor,
                savedScheduleTitle,
                savedScheduleContent
        );

        //7. 만든거 반환 해주기
        return scheduleSaveResponse;

    }
    // 일정 전체 조회
    // 1. 회원 목록 조회
    @Transactional(readOnly = true)
    public ScheduleGetAllList ScheduleGetAllResponse() {

        List<Schedule> scheduleList = scheduleRepository.findAll();


        //2. 엔티티 -> dto 바꾸기 (stream으로)
        List<ScheduleGetAllResponse> scheduleGetAllResponseList =
                scheduleList.stream()
                        .map(schedule -> new ScheduleGetAllResponse(
                                schedule.getId(),
                                schedule.getAuthor(),
                                schedule.getTitle(),
                                schedule.getContent()
                        ))
                        .toList();
        // 3. 외부 dto 만들기
        ScheduleGetAllList getAllResponse = new ScheduleGetAllList(scheduleGetAllResponseList);

        // 4. 반환 하기
        return getAllResponse;

    }

    // 일정 단건 조회
    // 1. 컨트롤러에서 데이터 받기 ( id )
    @Transactional(readOnly = true)
    public ScheduleGetResponse findById(Long id) {

        // 2. DB에서 아이디로 일정 조회
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 일정이 없습니다"));

        // 3. 데이터 준비하기
        Long scheduleId = schedule.getId();
        String author = schedule.getAuthor();
        String title = schedule.getTitle();
        String content = schedule.getContent();


        // 4. 응답 dto 만들기
        ScheduleGetResponse scheduleGetResponse = new ScheduleGetResponse(
                scheduleId,
                author,
                title,
                content
        );

        // 5. 반환하기
        return scheduleGetResponse;



    }

    // 일정 수정
    @Transactional
    // 1. 컨트롤러에서 데이터 받기 ( id , 요청 )
    public ScheduleGetResponse update(Long id, ScheduleSaveRequest request) {

        // 2. DB에서 아이디로 일정 조회
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 일정이 없습니다"));


        // 3. 데이터 수정하기
        schedule.setAuthor(request.getAuthor());  //request에서 가져온 author를 수정
        schedule.setTitle(request.getTitle());   //가져온 gettitle을 수정
        schedule.setContent(request.getContent()); //가져온 getcontent를 수정

        // 4. 데이터 저장하기
        Schedule updateSchedule = scheduleRepository.save(schedule);


        // 5. 응답 dto 생성
        ScheduleGetResponse scheduleGetResponse = new ScheduleGetResponse(
                updateSchedule.getId(),
                updateSchedule.getAuthor(),
                updateSchedule.getTitle(),
                updateSchedule.getContent()
        );

        return scheduleGetResponse;


    }

    // 일정 삭제
    @Transactional
    //1. DB에서 스케줄 찾기
    public void delete(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 일정이 없습니다"));

        //2. 삭제하기
        scheduleRepository.delete(schedule);
    }

}
