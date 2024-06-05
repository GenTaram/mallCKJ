package idusw.springboot.mallckj.repository;

import idusw.springboot.mallckj.entity.BlogEntity;
import idusw.springboot.mallckj.model.BlogDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogEntity, Long> { //interface, 상속

}
