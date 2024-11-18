package org.springsecurity.securityregisterlogin.service;

import org.springsecurity.securityregisterlogin.entity.Post;

import java.util.List;

public interface IPostService {
    public Post savePost(Post post);

    public List<Post> getAllPosts();

    public Boolean deletePost(int id);
}
