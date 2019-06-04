package com.microblog.repository;

import com.microblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

// Repository - a class that talks to the database
@Repository
public interface PostRespository extends JpaRepository<Post, Integer> {

    // find top 10 post by order of upvotes and last updated
    List<Post> findTop10ByOrderByUpvotesDescCreatedtimeDesc();

    // update upvotes
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Post p SET p.upvotes = p.upvotes + 1 WHERE p.id =:postId")
    public int upvote(@Param("postId") int postId);

    // update downvotes
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Post p SET p.downvotes = p.downvotes + 1 WHERE p.id =:postId")
    public int downvote(@Param("postId") int postId);

}