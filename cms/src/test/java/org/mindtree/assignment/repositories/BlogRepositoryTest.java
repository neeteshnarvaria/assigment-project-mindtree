package org.mindtree.assignment.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

/**
 * Created by M1038226 on 12/29/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {

    @Autowired
    BlogRepository blogRepository;

    @Test
    public void whenFetchBlogs_thenShouldReturnListOfBlog(){
        assertThat(blogRepository.findAll(),is(not(nullValue())));
    }
}