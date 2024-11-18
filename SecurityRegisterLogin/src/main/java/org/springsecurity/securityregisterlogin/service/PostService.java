package org.springsecurity.securityregisterlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springsecurity.securityregisterlogin.entity.Post;
import org.springsecurity.securityregisterlogin.repository.PostRepository;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Boolean deletePost(int id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            postRepository.delete(post);
            return true;
        }
        return false;
    }
}
