package com.blog.blogappapis.controllers;

import com.blog.blogappapis.payloads.ApiResponse;
import com.blog.blogappapis.payloads.PostDto;
import com.blog.blogappapis.payloads.PostResponse;
import com.blog.blogappapis.services.FileService;
import com.blog.blogappapis.services.PostService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private FileService fileService;
    @Value("${project.image}")
    private String path;
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
        PostDto createPost=this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto> >getPostByUser(@PathVariable Integer userId){
        List<PostDto> posts=this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto> >getPostByCategory(@PathVariable Integer categoryId){
        List<PostDto> posts=this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }
    @GetMapping("/posts")
    public  ResponseEntity<PostResponse> getAllPost(@RequestParam (value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
                                                          @RequestParam (value = "pageSize",defaultValue = "3",required = false) Integer pageSize){
PostResponse postResponse=this.postService.getAllPost(pageNumber,pageSize);
return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);

    }
    @GetMapping("/posts/{postId}")
    public  ResponseEntity<PostDto> getSingleUser(@PathVariable Integer postId){
        return ResponseEntity.ok(this.postService.getPostById(postId));
    }
    @DeleteMapping("/post/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new  ResponseEntity<ApiResponse>(new ApiResponse("post deleted successfully",true),HttpStatus.OK);
    }
    @PutMapping("/post/{postId}")
    public ResponseEntity<ApiResponse> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
        PostDto updatedPost=  this.postService.updatePost(postDto, postId);
        return new  ResponseEntity<ApiResponse>(new ApiResponse("post updated successfully",true),HttpStatus.OK);

    }
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords") String Keywords){
        List<PostDto> result=this.postService.searchPosts(Keywords);
        return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
    }
    //post image upload
    @PostMapping("/post/image/upload/{postId}")
    public ResponseEntity<PostDto> uploadPostImage(
            @RequestParam("image")MultipartFile image,
            @PathVariable Integer postId
            ) throws IOException {
        PostDto postDto=   this.postService.getPostById(postId);
      String fileName=  this.fileService.uploadImage(path,image);


     postDto.setImageName(fileName);
    PostDto updatePost= this.postService.updatePost(postDto,postId);

    return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
    }

//method to serve file
    @GetMapping(value = "post/profiles/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            @PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException {
        InputStream resource= this.fileService.getResource(path,imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy( resource,response.getOutputStream());
    }
}
