package pl.akademia.hibernate.dao;

import org.springframework.data.repository.CrudRepository;
import pl.akademia.hibernate.model.Post;
//
public interface PostDao extends CrudRepository<Post,Long>   {

}
