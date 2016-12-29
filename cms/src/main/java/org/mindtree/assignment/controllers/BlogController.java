package org.mindtree.assignment.controllers;

import org.mindtree.assignment.models.Blog;
import org.mindtree.assignment.models.Comments;
import org.mindtree.assignment.models.MultiMedia;
import org.mindtree.assignment.repositories.BlogRepository;
import org.mindtree.assignment.repositories.CommentsRepository;
import org.mindtree.assignment.repositories.MultiMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Neetesh Narvaria - M1038226 on 12/24/2016.
 */
@Controller
public class BlogController {

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    MultiMediaRepository multiMediaRepository;

    @Autowired
    CommentsRepository commentsRepository;

    @RequestMapping("/submitBlog")
    public String submitBlog(@ModelAttribute("blogForm") Blog blog, @RequestParam("file") MultipartFile file,@RequestParam(required = false) String blogId) throws IOException {
        if(!file.isEmpty()) {
            MultiMedia multiMedia = new MultiMedia();
            multiMedia.setName(file.getName());
            multiMedia.setData(file.getBytes());
            multiMedia.setContentType(file.getContentType());
            blog.setMedia(multiMediaRepository.save(multiMedia));
        }
        if(!"".equalsIgnoreCase(blogId)&& blogId != null){
            blog.setId(Long.parseLong(blogId));
        }
        blogRepository.save(blog);
        return "redirect:/";
    }

    @RequestMapping("/deleteBlog/{blogId}")
    public String deleteBlog(@PathVariable long blogId) throws IOException {
        commentsRepository.delete(commentsRepository.findCommentsByBlogId(blogId));
        blogRepository.delete(blogRepository.findOne(blogId));
        return "redirect:/";
    }

    @RequestMapping({"/","/home"})
    public String showIndex(Model model,Map<String, Object> modelProperties){
        modelProperties.put("message", this.message);
        model.addAttribute("blogForm", new Blog());
        List<Blog> blogs =  blogRepository.findAll();
        model.addAttribute("blogs",blogs);
        return "index";
    }

    @RequestMapping(value = "/imageController/{imageId}")
    @ResponseBody
    public byte[] helloWorld(@PathVariable long imageId)  {
        MultiMedia multiMedia = multiMediaRepository.findOne(imageId);
        return (multiMedia !=null)?multiMedia.getData():null;
    }

    @RequestMapping("/showBlog/{blogId}")
    public String showBlog(@PathVariable long blogId,Model model){
        Blog blog = blogRepository.findOne(blogId);
        List<Comments> comments = commentsRepository.findCommentsByBlogId(blog.getId());
        model.addAttribute("blog",blog);
        model.addAttribute("comments",comments);
        return "blogDetails";
    }

    @RequestMapping(value = "/addComments",produces = "application/json")
    @ResponseBody
    public Comments addComments(@RequestBody Map<String,String> data){
        Comments comments = new Comments();
        if(data.containsKey("blogId"))
            comments.setBlogId(Long.parseLong(data.get("blogId")));
        if(data.containsKey("userComment"))
            comments.setComment(data.get("userComment"));
        if(data.containsKey("commentUser")) {
            if("".equalsIgnoreCase(data.get("commentUser"))){
                comments.setUserName("anonymous");
            }else {
                comments.setUserName(data.get("commentUser"));
            }
        }
        comments.setCreationTime(new Date().toString());
        comments = commentsRepository.save(comments);
        return comments;
    }


    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }

        model.setViewName("403");
        return model;

    }

}
