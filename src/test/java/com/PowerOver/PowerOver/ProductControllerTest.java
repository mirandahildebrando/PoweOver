package com.PowerOver.PowerOver;


import com.PowerOver.PowerOver.controller.ProductController;
import com.PowerOver.PowerOver.dto.ProductDTO;
import com.PowerOver.PowerOver.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class) 
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void shouldReturnStatus200WhenListingProducts() throws Exception {
        
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
    }

    @Test
    void mustCreateProductViaPost() throws Exception {
       
        String json = """
                {
                    "productName": "Teclado",
                    "productPrice": 100.0,
                    "productQuantity": 5
                }
                """;

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }
}