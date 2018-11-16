package pl.akademia.hibernate.dao;

import org.springframework.data.repository.CrudRepository;
import pl.akademia.hibernate.model.Comment;

public interface CommentDao extends CrudRepository<Comment,Long>{
}
