package com.microblog.controller;

import com.microblog.model.Ips;
import com.microblog.model.Post;
import com.microblog.repository.IpsRespository;
import com.microblog.repository.PostRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

//tells Spring that this class is a Controller
@RestController
public class MicroblogController{

    // Spring will automatically resolve the instance and inject it into the class that declared it
    @Autowired
    PostRespository postRespository;
    @Autowired
    IpsRespository ipsRespository;

    // get all posts
    @GetMapping("/post")
    public List<Post> index(){
        return postRespository.findAll();
    }

    // add a new post
    @PostMapping("/post")
    public Post create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String content = body.get("content");
        return postRespository.save(new Post(title, content));
    }

    // update a post
    @PutMapping("/post/{id}")
    public Post update(@PathVariable String id, @RequestBody Map<String, String> body){
        int postId = Integer.parseInt(id);
        // getting post
        Post post = postRespository.findOne(postId);
        post.setTitle(body.get("title"));
        post.setContent(body.get("content"));
        return postRespository.save(post);
    }

    // delete a post
    @DeleteMapping("post/{id}")
    public boolean delete(@PathVariable String id){
        int postId = Integer.parseInt(id);
        postRespository.delete(postId);
        return true;
    }

    // upvote a post
    @Transactional
    @PostMapping("/post/upvote/{id}")
    public int upvote(@PathVariable String id, HttpServletRequest request){
        String ip = request.getRemoteAddr();
        if(ipsRespository.findByIpContaining(ip).isEmpty()){
            ipsRespository.save(new Ips(ip));
        }
        else{
            return -1;
        }
        int postId = Integer.parseInt(id);
        return postRespository.upvote(postId);
    }

    // downvote a post
    @Transactional
    @PostMapping("/post/downvote/{id}")
    public int downvote(@PathVariable String id, HttpServletRequest request){
        String ip = request.getRemoteAddr();
        if(ipsRespository.findByIpContaining(ip).isEmpty()){
            ipsRespository.save(new Ips(ip));
        }
        else{
            return -1;
        }

        int postId = Integer.parseInt(id);
        return postRespository.downvote(postId);
    }

    // get top 10 posts
    @GetMapping("/post/toppost")
    public List<Post> getTopPost(){
        return postRespository.findTop10ByOrderByUpvotesDescCreatedtimeDesc();
    }
}