package idusw.springboot.mallckj.service;

import idusw.springboot.mallckj.entity.BlogEntity;
import idusw.springboot.mallckj.model.BlogDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Override
    public int create(BlogDto dto) {
        return 0;
    }

    @Override
    public BlogDto read(BlogDto dto) {
        return null;
    }

    @Override
    public List<Member> readAll() {
        return null;
    }

    @Override
    public int update(BlogDto dto) {
        return 0;
    }

    @Override
    public int delete(BlogDto dto) {
        return 0;
    }
}
