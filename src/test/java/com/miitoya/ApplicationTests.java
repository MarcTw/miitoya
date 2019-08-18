package com.miitoya;

import com.miitoya.model.Book;
import com.miitoya.model.V_token;
import com.miitoya.repository.ItemRespository;
import com.miitoya.repository.V_tokenRepository;
import com.miitoya.repository.VendorRepository;
import com.miitoya.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests extends  Thread{

	@Test
	public void contextLoads() {
	}

	@Autowired
	private BookService bookService;
	@Autowired
	private ItemRespository itemRespository;
	@Test
	public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
		List<Book> books = bookService.list();
		books.forEach(s -> System.out.println(s.getName()));
		Assert.assertEquals(books.size(), 2);
	}

	@Autowired
	private V_tokenRepository v_tokenRepository;
	@Autowired
	private VendorRepository vendorRepository;

	@Test
	public void vetV_tokenRepository(){
		v_tokenRepository.save(new V_token("abccdded1",2l,new Timestamp(1566061505000l),new Timestamp(1566063505000l)));
	}

	@Test
	public void jaisdfjaodfj(){
		Object a = vendorRepository.getNameFromV_ID2(2l);
		List<String> b = vendorRepository.getNameFromV_ID2(2l);

		b.stream().forEach(string ->{
			System.out.println(string);
		});
	}

	@Test
	public void insertRandom(){
		Long v_id = 2l;
		Random ran = new Random();
		for (int i = 0; i<=1500 ; i++) {
			itemRespository.inserItem(v_id,new BigDecimal(ran.nextInt(3000)+2000));
		}

	}


}
