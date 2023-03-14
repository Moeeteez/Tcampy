package com.programming.techie.springngblog.security;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.exception.PostNotFoundException;
import com.programming.techie.springngblog.model.Post;
import com.programming.techie.springngblog.model.Reaction;
import com.programming.techie.springngblog.repository.PostRepository;
import com.programming.techie.springngblog.repository.ReactionRepository;
import com.programming.techie.springngblog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {

    @Autowired
    private AuthService authService;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ReactionRepository reactionRepository;

    @Transactional
    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }


    public void createPost(PostDto postDto) {
        Post post = mapFromDtoToPost(postDto);
        postRepository.save(post);
    }



    @Transactional
    public PostDto readSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
        return mapFromPostToDto(post);
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUsername(post.getUsername());
        return postDto;
    }
    @Transactional
    public boolean updatePost(Long postId, PostDto postDto) {
        Optional<Post> postOpt = postRepository.findById(postId);
        if (postOpt.isPresent()) {
            Post post = postOpt.get();

            // Update the fields of the post entity based on the data in the DTO
            post.setTitle(postDto.getTitle());
            post.setContent(postDto.getContent());

            postRepository.save(post);
            return true;
        } else {
            return false;
        }
    }
    @Transactional
    public boolean deletePost(Long postId) {
        Optional<Post> postOpt = postRepository.findById(postId);
        if (postOpt.isPresent()) {
            postRepository.delete(postOpt.get());
            return true;
        } else {
            return false;
        }
    }
    private Post mapFromDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        post.setCreatedOn(Instant.now());
        post.setUsername(postDto.getUsername());
        post.setUpdatedOn(Instant.now());
        return post;
    }


    public Reaction createReaction(Long postId, Reaction reaction) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + postId));
        reaction.setPost(post);
        post.setReaction(reaction);
        return reactionRepository.save(reaction);
    }

    public List<Post> getAllPostsWithReactions() {
        return postRepository.findAll();
    }
}
