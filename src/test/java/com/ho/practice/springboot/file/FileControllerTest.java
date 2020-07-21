package com.ho.practice.springboot.file;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(FileController.class)
public class FileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String serviceUrl ="/files";

    @Test
    public void testUploadFile() throws Exception {
        // given
        MockMultipartFile file =
            new MockMultipartFile(
                    "myFile",
                    "sample.jpg",
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    "image-data".getBytes(StandardCharsets.UTF_8));

        // when
        ResultActions actions = mockMvc.perform(
                multipart(serviceUrl).file(file)
            )
            .andDo(print());

        //then
        actions
            .andExpect(status().isOk())
            .andExpect(content().string("success"))
            ;
    }

    @Test
    public void testDownloadFile() throws Exception {
        // given

        // when
        ResultActions actions = mockMvc.perform(get(serviceUrl))
            .andDo(print());
            
        //then
        actions
            .andExpect(status().isOk())
            .andExpect(header().string("Content-Type", "application/zip"))
            .andExpect(header().string("Content-disposition", "attachment; filename=sample.zip"))
            ;
    }

}