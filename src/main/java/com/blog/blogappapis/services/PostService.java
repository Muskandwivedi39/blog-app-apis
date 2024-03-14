package com.blog.blogappapis.services;

import com.blog.blogappapis.payloads.PostDto;
import com.blog.blogappapis.payloads.PostResponse;

import java.util.List;

public interface PostService {
     PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
     PostDto updatePost(PostDto postDto, Integer Id);
     void deletePost(Integer Id);
     PostResponse getAllPost(Integer pageNumber, Integer pageSize);
     PostDto getPostById(Integer postId);
     List<PostDto> getPostsByCategory(Integer categoryId);
    List<PostDto> getPostsByUser(Integer userId);

    List<PostDto> searchPosts(String keyword);
}
