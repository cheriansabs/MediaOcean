/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xyz.scheduler;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.google.gson.Gson;
import com.xyz.billing.Category;
import com.xyz.model.Bill;
import com.xyz.model.Item;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

 

    @Test
    @WithMockUser
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {
    	StringBuffer teams = new StringBuffer();
    	
    	teams.append("pune,");
    	teams.append("mumbai,");
    	teams.append("delhi,");
    	teams.append("kolkatta,");
    	teams.append("hyderabad,");
    	teams.append("chennai,");
    	teams.append("bangalore");
    	
    	
    	FormLoginRequestBuilder login = formLogin()
                .user("user")
                .password("password");
        this.mockMvc.perform(get("/schedule")./*with(user("7xyz").password("abc7").roles("USER")).*/param("teams", teams.toString()).param("date", "1/1/2016"))
                .andDo(print()).andExpect(status().isOk());
               
    }
    
    @Test
    @WithMockUser
    public void testBilling() throws Exception {
    	
    	
    	
    	FormLoginRequestBuilder login = formLogin()
                .user("user")
                .password("password");
    	List<Item> lstItems = new ArrayList<>();
    	lstItems.add(new Item("Shoes", 2000D, Category.A));
       	lstItems.add(new Item("TV", 10000D, Category.B));
       	lstItems.add(new Item("Pen", 100D, Category.C));
    	
       	
       	Gson gson = new Gson();
       	
        MvcResult result=this.mockMvc.perform(post("/generateBill").with(csrf()).with(user("xyz").password("abc").roles("USER")).contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(lstItems))) 
               /* .andDo(print())*/.andExpect(status().isOk()).andReturn();
        Bill bill = gson.fromJson(result.getResponse().getContentAsString(),Bill.class);
        System.out.println(bill);
      assertEquals(bill.getTotalSalesTax(), 2200D,0);
      assertEquals(bill.getTotalCost(), 14300D,0);
       
                //.andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
    }

}
