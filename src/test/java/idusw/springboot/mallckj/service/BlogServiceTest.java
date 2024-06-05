package idusw.springboot.mallckj.service;

import idusw.springboot.mallckj.entity.BlogEntity;
import idusw.springboot.mallckj.entity.MemberEntity;
import idusw.springboot.mallckj.model.BlogDto;
import idusw.springboot.mallckj.repository.BlogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BlogServiceTest {
    @Autowired
    BlogRepository blogRepository;
    @Test
    public void registerBlog() {
         BlogDto dto = BlogDto.builder()
                .title("test12")
                .content("content12")
                .writerIdx(1L)
                .block("non")
                .build();

        blogRepository.save(dtoToEntity(dto));
    }
    BlogEntity dtoToEntity(BlogDto dto) {
        MemberEntity member = MemberEntity.builder()
                .idx(dto.getWriterIdx())
                .build();
        BlogEntity entity = BlogEntity.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .views(dto.getViews())
                .writer(member)
                .build();
        return entity;
    }
    // MemberEntity -> : Controller에서는 Member를 다룸
    BlogDto entityToDto(BlogEntity entity, MemberEntity member) {
        BlogDto dto = BlogDto.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .views(entity.getViews())
                .content(entity.getContent())
                .writerIdx(member.getIdx())
                .writerName(member.getName())
                .writerEmail(member.getEmail())
                .regDate((entity.getRegDate()))
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}
